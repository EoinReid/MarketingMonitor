/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketingmonitor;

import DAOs.MySqlDao;
import DAOs.TestDaoI;
import DAOs.MySqlTestDao;
import DTOs.Ad;
import Exceptions.DaoException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.*;
import java.io.IOException;
import java.util.Calendar;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.call.GetItemCall;
import com.ebay.sdk.helper.ConsoleUtil;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;
import com.ebay.sdk.call.GetItemCall;

import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import java.util.Scanner;
import DTOs.Ad;
import DTOs.Statistics;
import DTOs.User;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author tiarn
 */
public class Server {

    TestDaoI testDao = null;

    private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private static final Level LOG_LEVEL = Level.INFO;
    private FileHandler logFile = null;

    public static void main(String[] args) {
        LOGGER.setLevel(LOG_LEVEL);
        Server server = new Server();
        server.start();
    }

    public void start() {
        try {

            logFile = new FileHandler("Server.log", true);

            logFile.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(logFile);

            LOGGER.info("Server Starting....");

            ServerSocket ss = new ServerSocket(8080);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true) // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection, 
                // and open a new socket to communicate with the client
                //Client logs in here         
                Scanner in = new Scanner(socket.getInputStream());

                OutputStream os = socket.getOutputStream();
                PrintWriter out = new PrintWriter(os, true);
                clientNumber++;

                LOGGER.log(Level.INFO, "A Client has connected from the address: {0}", socket.getInetAddress());

                System.out.println("Server: Client " + clientNumber + " has connected.");
                testDao = new MySqlTestDao();
                Thread t = new Thread(new ClientHandler(socket, testDao, clientNumber));
                t.start();
            }
        } catch (IOException e) {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    public class ClientHandler implements Runnable // each ClientHandler communicates with one Client
    {

        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        int clientNumber;
        TestDaoI dao;

        public ClientHandler(Socket clientSocket, TestDaoI ITestDao, int clientNumber) {
            this.dao = ITestDao;

            try {
                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
                this.socketReader = new BufferedReader(isReader);

                OutputStream os = clientSocket.getOutputStream();
                this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer

                this.clientNumber = clientNumber;  // ID number that we are assigning to this client

                this.socket = clientSocket;  // store socket ref for closing 

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;

            try {
                while ((message = socketReader.readLine()) != null) // listen at socket for message from client (wait)
                {
                    System.out.println(message);
                    LOGGER.log(Level.INFO, "Command Received from the client: {0}", message);
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);

                    if (message.startsWith("Login")) {
                        String returnPoint;
                        String input = message.substring(5);
                        String[] buildUser = input.split(",");
                        //Send the username to the database
                        User userLogin = dao.Login(buildUser[0]);
                        String AccUser = userLogin.getUsername();
                        String AccPassword = userLogin.getPassword();
                        //Tests if the username and Pasword match
                        if (AccUser.equals(buildUser[0]) && AccPassword.equals(buildUser[1])) {
                            returnPoint = "1";
                        } else {
                            returnPoint = "0";
                        }
                        socketWriter.println(returnPoint);

                    }

                    if (message.startsWith("AdSearch")) {
                        //This function calls the DAO and returns an add that matches a certain SKU                    
                        String input = message.substring(8);
                        System.out.println(input);
                        Ad adReturn = dao.findAd(input);
                        String json = convertToJson(adReturn);
                        socketWriter.println(json);
                    }

                    if(message.startsWith("viewCount2")){
                        //throwing erros so commented for now
//                      String input = message.substring(9);
//                         List<Ad> ads = dao.popularAd2(input);
//                        String json = convertToJsonList(ads);
//                        System.out.println(json);
//                        socketWriter.println(json);  // send message to client
                    }
                    
                    if (message.startsWith("priceCompare")) {
                        //This returns some info about the prices of certain objects      
                        String input = message.substring(13);
                        String[] tokens = input.split(" ");
                        String county;
                        county = tokens[tokens.length - 1];                    
                        String[] finalTokens = Arrays.copyOf(tokens, tokens.length - 1);                      
                        for (String s : finalTokens) {
                            System.out.println(s);  
                        }
                        List<Double> prices = dao.PriceCompare(finalTokens, county);
                        System.out.println(input);
                           double max = 0;
                        for(int i = 0; i < prices.size(); i++){
                     
                            if(max > prices.get(i)){
                                max = prices.get(i);
                                System.out.println(max);
                            }
                        
                        }      
                        System.out.println(max);
                        double min = 0;
                         for(int i = 0; i < prices.size(); i++){
                     
                            if(min < prices.get(i)){
                                min = prices.get(i);
                            
                            }
                        
                        } 
                         System.out.println(min);
                        int noOfReturns = prices.size();
                        Double totalPrice = 0.0;
                        Double median;
                        //If there is an even number of return this returns the median
                        if ((noOfReturns % 2) == 0) {
                            int medianPos = noOfReturns / 2;
                            median = prices.get(medianPos);
                        } else {
                            //Retursn the median for an odd number of turns
                            int medianPos = noOfReturns / 2;
                            medianPos += 0.5;
                            median = prices.get(medianPos);
                        }
                        for (int i = 0; i < 3; i++) {
                            totalPrice = totalPrice + prices.get(i);
                        }
                        Double mean = totalPrice / noOfReturns;
                        Statistics s = new Statistics(max, min, mean, median);
                        String json = convertToJsonStats(s);
                        socketWriter.println(json);
                    }
                    if (message.startsWith("viewCount")) {
                        List<Ad> ads = dao.popularAd();
                        String json = convertToJsonList(ads);
                        System.out.println(json);
                        socketWriter.println(json);  // send message to client
                    }
                }
                socket.close();
            } catch (IOException e) {

                LOGGER.warning("Exception caught");
                e.printStackTrace();
            } catch (DaoException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }

    //Test call to test ebay credentials and connection, returns time on US server
    public void testebayCall() {
        try {
            //test call to see if ebay connection can be established

            // [Step 1] Initialize eBay ApiContext object
            System.out.println("===== [1] Account Information ====");
            ApiContext apiContext = getApiContext();

            // [Step 2] Create call object and execute the call
            GeteBayOfficialTimeCall apiCall = new GeteBayOfficialTimeCall(apiContext);
            System.out.println("Begin to call eBay API, please wait ... ");
            Calendar cal = apiCall.geteBayOfficialTime();
            System.out.println("End to call eBay API, show call result ...");

            // [Setp 3] Handle the result returned
            System.out.println("Official eBay Time : " + cal.getTime().toString());
        } catch (Exception e) {
            System.out.println("Fail to get eBay official time.");
            e.printStackTrace();
        }
    }

    //Returns a single add on ebay
//    public void getEbayAd() {
//        try {
//            //test call to see if ebay connection can be established
//
//            // [Step 1] Initialize eBay ApiContext object
//            System.out.println("===== [1] Account Information ====");
//            ApiContext apiContext = getApiContext();
//
//            // [Step 2] Create call object and execute the call
//          
//
//            // [Setp 3] Handle the result returned
//            // This will send the returned info to the client
//            System.out.println("Official eBay Time : " + cal.getTime().toString());
//        } catch (Exception e) {
//            System.out.println("Failed to get add");
//            e.printStackTrace();
//        }
//    }
    // Function for creating your ebay authentication code
    private static ApiContext getApiContext() throws IOException {

        String input;
        ApiContext apiContext = new ApiContext();

        //set Api Token to access eBay Api Server
        ApiCredential cred = apiContext.getApiCredential();
        input = ConsoleUtil.readString("AidanVau-MarketMo-SBX-53882c1d0-4dde0f4d");

        cred.seteBayToken(input);

        //set Api Server Url
        input = ConsoleUtil.readString("https://api.sandbox.ebay.com/wsapi");

        apiContext.setApiServerUrl(input);

        return apiContext;
    }

    public String findEbayAd(String Keyword) {
        String ItemID = null;

        try {
            //Finds the item ID of an add on ebay

            // [Step 1] Initialize eBay ApiContext object
            System.out.println("===== [1] Account Information ====");
            ApiContext apiContext = getApiContext();

            // [Step 2] Create call object and execute the call
            GeteBayOfficialTimeCall apiCall = new GeteBayOfficialTimeCall(apiContext);
            System.out.println("Begin to call eBay API, please wait ... ");
            Calendar cal = apiCall.geteBayOfficialTime();
            System.out.println("End to call eBay API, show call result ...");

            // [Setp 3] Handle the result returned
        } catch (Exception e) {
            System.out.println("Fail to get eBay official time.");
            e.printStackTrace();
        }

        return ItemID;
    }

    public String convertToJsonList(List<Ad> a) throws DaoException {
        String jsonstr = "{\"ads\":[";
        int moviecount = 0;

        for (Ad ad : a) {
            if (moviecount > 0 && moviecount < a.size()) {
                jsonstr += ",";
            }
            moviecount++;

            jsonstr += "{\"Type\":\"" + ad.getType() + "\","
                    + "\"Title\":\"" + ad.getTitle() + "\","
                    + "\"Price\":\"" + ad.getPrice() + "\","
                    + "\"Section\":\"" + ad.getSection() + "\","
                    + "\"Description\":\"" + ad.getDescription() + "\","
                    + "\"ID\":\"" + ad.getId() + "\","
                    + "\"Currency\":\"" + ad.getCurrency() + "\","
                    + "\"SubSection\":\"" + ad.getSubSection() + "\","
                    + "\"Time\":\"" + ad.getTime() + "\","
                    + "\"County\":\"" + ad.getCounty() + "\","
                    + "\"Ebay\":\"" + ad.getEbay() + "\","
                    + "\"DoneDeal\":\"" + ad.getDoneDeal() + "\"}";

        }
        jsonstr += "] }";
        return jsonstr;

    }

    public String convertToJson(Ad a) throws DaoException {
        Ad ad = a;

        String jsonStr = "{\"ads\":";

        jsonStr += "{\"Type\":\"" + ad.getType() + "\","
                + "\"Title\":\"" + ad.getTitle() + "\","
                + "\"Price\":\"" + ad.getPrice() + "\","
                + "\"Section\":\"" + ad.getSection() + "\","
                + "\"Description\":\"" + ad.getDescription() + "\","
                + "\"Id\":\"" + ad.getId() + "\","
                + "\"Currency\":\"" + ad.getCurrency() + "\","
                + "\"Subsection\":\"" + ad.getSubSection() + "\","
                + "\"Time\":\"" + ad.getTime() + "\","
                + "\"ViewCount\":\"" + ad.getViewCount() + "\","
                + "\"County\":\"" + ad.getCounty() + "\","
                + "\"Ebay\":\"" + ad.getEbay() + "\","
                + "\"DoneDeal\":\"" + ad.getDoneDeal() + "\"}";

        jsonStr += " }";

        System.out.println(jsonStr);

        return jsonStr;
    }

    public String convertToJsonStats(Statistics s) throws DaoException {
        Statistics stat = s;

        String jsonStr = "{\"Statistics\":";

        jsonStr += "{\"maxCost\":\"" + stat.getMaxCost() + "\","
                + "\"minCost\":\"" + stat.getMinCost() + "\","
                + "\"getMean\":\"" + stat.getMean() + "\","
                + "\"getMedian\":\"" + stat.getMedian() + "\"}";

        jsonStr += " }";

        System.out.println(jsonStr);

        return jsonStr;
    }
}
