package ir.persikala.dao;

import javax.ejb.Stateless;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ir.persikala.exception.FindUserByMobileException;
import ir.persikala.user.request.findmobile.FindUserMobileRequest;
import ir.persikala.user.request.findmobile.Match_phrase;
import ir.persikala.user.request.findmobile.Query;
import ir.persikala.user.request.insert.UserEntityRequestInsert;
import ir.persikala.user.response.findmobile.UserFindEntity;

/**
 * Session Bean implementation class UserDao
 */
@Stateless
public class UserDao implements UserDaoLocal {

    /**
     * Default constructor. 
     */
    public UserDao() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void InsertUser(UserEntityRequestInsert userEntityRequestInsert) {
    	UserEntityRequestInsert request=new UserEntityRequestInsert();
    	request=userEntityRequestInsert;
    	Client client=ClientBuilder.newClient();
    	String targetResource="http://192.168.10.77:9200/user_index/_doc";
    	Entity<UserEntityRequestInsert> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	String json=response.readEntity(String.class);
        System.err.println(json);
    }
    @Override
    public UserFindEntity findUserByMobyle(String mobile) throws FindUserByMobileException{
    	FindUserMobileRequest request=new FindUserMobileRequest();
    	Match_phrase match_phraseObject=new Match_phrase();
    	match_phraseObject.setMobile(mobile);
    	Query query=new Query();
    	query.setMatch_phrase(match_phraseObject);
    	request.setQuery(query);
    	Client client=ClientBuilder.newClient();
    	String targetResource="http://192.168.10.77:9200/user_index/_search";
    	Entity<FindUserMobileRequest> entity=Entity.entity(request, MediaType.APPLICATION_JSON);
    	Response response=client.target(targetResource)
    			.request(MediaType.APPLICATION_JSON)
    			.post(entity);
    	String json=response.readEntity(String.class);
    	System.err.println(json);
    	Jsonb jsonb=JsonbBuilder.create();
    	UserFindEntity userFindEntity=new UserFindEntity();
    	try {
    	userFindEntity=jsonb.fromJson(json, UserFindEntity.class);
    	}catch (Exception e) {
			throw new FindUserByMobileException("Exception by finding user");
		}
        return userFindEntity;
    }
    

}
