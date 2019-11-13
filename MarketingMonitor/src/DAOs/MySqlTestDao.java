/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

import Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;


/**
 *
 * @author tiarn
 */
public class MySqlTestDao extends DAOs.MySqlDao implements TestDaoI {
    
    @Override
    
    public String testCon() throws DaoException
    {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try
        {
            con = this.getConnection();
            
            if (con != null) 
                {
                    System.out.println("Connected to Server!");
                }
            
            
        }
        catch (SQLException e) 
        {
            throw new DaoException("testCon() " + e.getMessage());
        }
        finally 
        {
            try 
            {
                if (rs != null) 
                {
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (con != null) 
                {
                    freeConnection(con);
                }
            } 
            catch (SQLException e) 
            {
                throw new DaoException("testCon() " + e.getMessage());
            }
        }
        return null;
        
    }
    
    @Override
    public User Login(int mId) throws DaoException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User u = null;
        try {
            con = this.getConnection();

            String query = "SELECT username, password FROM users WHERE username = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, mId);

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
    
}
