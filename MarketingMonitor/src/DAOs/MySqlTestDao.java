/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import DTOs.User;
import DTOs.Ad;
import Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import DTOs.Ad;
import DTOs.User;


/**
 *
 * @author tiarn
 */
public class MySqlTestDao extends DAOs.MySqlDao implements TestDaoI {
    
     
    @Override
    public User Login(String mUsername) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT username, password FROM users WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, mUsername);

            rs = ps.executeQuery();
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                u = new User(username,password);
            }
        } catch (SQLException e) {
            throw new DaoException("Login() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("Login() " + e.getMessage());
            }
        }
        return u;     // u may be null 
    }
    
    
    //This method returns the title and price an ad that meets a certain keyword search
    @Override
    public Ad findAd(String akeyword) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Ad a = null;

        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT title, price, view_Count, county, ebay, donedeal FROM adds WHERE description like ? ";
            ps = con.prepareStatement(query);
            ps.setString(1, "%"+akeyword+"%");

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();

            while (rs.next()) {
                String title = rs.getString("Title");
                Double price = rs.getDouble("Price");
                int viewCount = rs.getInt("view_Count");
                String county = rs.getString("County");
                String ebay = rs.getString("Ebay");
                String donedeal = rs.getString("DoneDeal");
                a = new Ad(title,price,viewCount, county, ebay, donedeal);

            }
        } catch (SQLException e) {
            throw new DaoException("FindAd() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("FindAd() " + e.getMessage());
            }
        }
        return a;     
    }
    

    @Override
    public List<Double> PriceCompare(String[] akeyword, String bkeyword) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        double price;
        List<Double> prices = new ArrayList<>();
        String searchedBy = "WHERE Description LIKE ";
        
        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();            
            String query = "SELECT title, price FROM adds WHERE Description Like ? AND COUNTY = ? ORDER BY Price";
            ps = con.prepareStatement(query);
            //Iterate through array of keywords
            for(int i =0; i< 3; i++){
                if(i > 0){
                    searchedBy+= "AND Description LIKE ";
                }
            searchedBy+= " %" + akeyword[i] + "% ";    
            }
            ps.setString(1, akeyword[1]);
            ps.setString(2, bkeyword);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();

            while (rs.next()) {
             price = rs.getDouble("Price");
             prices.add(price);
            }
            
        } catch (SQLException e) {
            throw new DaoException("PriceCompare()" + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("PriceCompare() " + e.getMessage());
            }
        }
        return prices;     
    }
    
    @Override
    public List<Ad> popularAd() throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String component;
        List<Ad> ads = new ArrayList<>();
        
        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT title, price, view_Count FROM adds GROUP BY view_Count LIMIT 5";
            ps = con.prepareStatement(query);
            

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();

            while (rs.next()) {
                String title = rs.getString("Title");
                Double price = rs.getDouble("Price");
                int viewCount = rs.getInt("view_Count");
                int count = 0;
                count++;
            //    ads.add(new Ad(title,price,viewCount)) ;

            }
        } catch (SQLException e) {
            throw new DaoException("popularAd() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("popularAd() " + e.getMessage());
            }
        }
        
        return ads;
    }
    
    @Override
    public List<Ad> popularAdTwo(String akeyword) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String component;
        List<Ad> ads = new ArrayList<>();
        
        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT title, price, view_Count FROM adds ORDER BY view_Count ASC LIMIT 6 WHERE description like ?";
            ps = con.prepareStatement(query);
            

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();

            while (rs.next()) {
                String title = rs.getString("Title");
                Double price = rs.getDouble("Price");
                int viewCount = rs.getInt("view_Count");
                int count = 0;
                count++;
               // ads.add(new Ad(title,price,viewCount)) ;

            }
        } catch (SQLException e) {
            throw new DaoException("popularAd() " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("popularAd() " + e.getMessage());
            }
        }
        
        return ads;
    }
    @Override
    public String testCon() throws DaoException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    


    
}
