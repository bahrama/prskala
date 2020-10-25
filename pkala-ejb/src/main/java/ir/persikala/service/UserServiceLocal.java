package ir.persikala.service;

import javax.ejb.Local;

import ir.persikala.exception.FindUserByMobileException;
import ir.persikala.user.request.insert.UserEntityRequestInsert;
import ir.persikala.user.response.findmobile.UserFindEntity;

@Local
public interface UserServiceLocal {

	void InsertUser(UserEntityRequestInsert userEntityRequestInsert);

	UserFindEntity findUserByMobyle(String mobile) throws FindUserByMobileException;

}
