package ir.persikala.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ir.persikala.dao.UserDaoLocal;
import ir.persikala.exception.FindUserByMobileException;
import ir.persikala.user.request.insert.UserEntityRequestInsert;
import ir.persikala.user.response.findmobile.UserFindEntity;

/**
 * Session Bean implementation class UserService
 */
@Stateless
public class UserService implements UserServiceLocal {

    /**
     * Default constructor. 
     */    
    public UserService() {
        // TODO Auto-generated constructor stub
    }
    @Inject
    private UserDaoLocal userDaoLocal;
    
    @Override
    public void InsertUser(UserEntityRequestInsert userEntityRequestInsert) {
    	userDaoLocal.InsertUser(userEntityRequestInsert);
    }
    
    @Override
    public UserFindEntity findUserByMobyle(String mobile) throws FindUserByMobileException {
        return userDaoLocal.findUserByMobyle(mobile);
    }
    }


