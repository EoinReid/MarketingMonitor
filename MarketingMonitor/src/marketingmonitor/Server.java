/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package marketingmonitor;

import DAOs.TestDaoI;
import DAOs.MySqlTestDao;
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

            testDao = new MySqlTestDao();

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
                clientNumber++;

                LOGGER.log(Level.INFO, "A Client has connected from the address: {0}", socket.getInetAddress());

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, testDao, clientNumber));
                t.start();

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
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
                    LOGGER.log(Level.INFO, "Command Received from the client: {0}", message);
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);
                    if (message.startsWith("testCon")) {

                        socketWriter.println("Connected!");  // send message to client

                    }
                }
                socket.close();
            } catch (IOException e) {

                LOGGER.warning("Exception caught");
                e.printStackTrace();
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
    public void getEbayAd() {
        try {
            //test call to see if ebay connection can be established

            // [Step 1] Initialize eBay ApiContext object
            System.out.println("===== [1] Account Information ====");
            ApiContext apiContext = getApiContext();

            // [Step 2] Create call object and execute the call
            GetItemCall apiCall = new GetItemCall(apiContext);
            System.out.println("Begin to call eBay API, please wait ... ");
             = apiCall.getItem();
            System.out.println("End to call eBay API, show call result ...");

            // [Setp 3] Handle the result returned
            System.out.println("Official eBay Time : " + cal.getTime().toString());
        } catch (Exception e) {
            System.out.println("Failed to get add");
            e.printStackTrace();
        }
    }

    // Function for creating your ebay authentication code
    private static ApiContext getApiContext() throws IOException {

        String input;
        ApiContext apiContext = new ApiContext();

        //set Api Token to access eBay Api Server
        ApiCredential cred = apiContext.getApiCredential();
        input = ConsoleUtil.readString("Enter your eBay Authentication Token: ");

        cred.seteBayToken(input);

        //set Api Server Url
        input = ConsoleUtil.readString("Enter eBay SOAP server URL (e.g., https://api.sandbox.ebay.com/wsapi): ");

        apiContext.setApiServerUrl(input);

        return apiContext;
    }
}
