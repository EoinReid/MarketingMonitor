/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAOs;

/**
 *
 * @author tiarn
 */

import Exceptions.DaoException;
import java.util.List;


public interface TestDaoI {
    public String testCon() throws DaoException;
    public User Login() throws DaoException;
}
