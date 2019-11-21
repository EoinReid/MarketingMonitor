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
public abstract class MySqlTestDao extends DAOs.MySqlDao implements TestDaoI {
    
     
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

            String query = "SELECT title, price FROM adds WHERE Description like %?%";
            ps = con.prepareStatement(query);
            ps.setString(1, akeyword);

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();

            while (rs.next()) {
                String title = rs.getString("Title");
                Double price = rs.getDouble("Price");
                a = new Ad(title,price);

            }
        } catch (SQLException e) {
            throw new DaoException("AdChecker() " + e.getMessage());
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
                throw new DaoException("adChecker() " + e.getMessage());
            }
        }
        return a;     
    }
    

    @Override
    public List<Double> PriceCompare(String akeyword) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        double price;
        List<Double> prices = new ArrayList<>();
        
        try {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            con = this.getConnection();

            String query = "SELECT title, price FROM adds WHERE Title like %?% ORDER BY Price DECENDING";
            ps = con.prepareStatement(query);
            ps.setString(1, akeyword);

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

            String query = "SELECT title, price, view_Count FROM adds GROUP BY view_Count";
            ps = con.prepareStatement(query);
            

            //Using a PreparedStatement to execute SQL...
            rs = ps.executeQuery();

            while (rs.next()) {
                String title = rs.getString("Title");
                Double price = rs.getDouble("Price");
                int viewCount = rs.getInt("View Count");
                int count = 0;
                count++;
                ads.add(new Ad(title,price,viewCount)) ;

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
    


    
}
