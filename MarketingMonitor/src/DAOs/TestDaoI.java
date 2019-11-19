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

import DTOs.User;
import DTOs.Ad;
import Exceptions.DaoException;
import java.util.List;
import DTOs.Ad;
import DTOs.User;


public interface TestDaoI {
    public String testCon() throws DaoException;
    public User Login(int mId) throws DaoException;
    public Ad findAd(String akeyword) throws DaoException;
    public List<Double> PriceCompare(String akeyword) throws DaoException;
    public Ad popularAd(String akeyword) throws DaoException;
}
