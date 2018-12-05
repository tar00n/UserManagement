package com.tarungarg;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {
	
	UserDao userDao = new UserDao();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {
		return userDao.getAllUsers();
	}
	
	@GET
	@Path("/users/{userid}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@PathParam("userid") int userid){
		return userDao.getUser(userid);
	}
	
	@POST
	@Path("/users")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createUser(User user){
		
		int result = userDao.addUser(user);
		if(result == 0){
			return "FAILURE";
		}
		return "SUCCESS";
	}
	
	@PUT
	@Path("/users")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String updateUser(User user){
		
		int result = userDao.updateUser(user);
		if(result == 0){
			return "FAILURE";
		}
		return "SUCCESS";
	}
	
	@DELETE
	@Path("/users/{userid}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteUser(@PathParam("userid") int userid, User user){
		
		int result = userDao.deleteUser(userid);
		if(result == 0){
			return "FAILURE";
		}
		return "SUCCESS";
	}
	
	@OPTIONS
	@Path("/users")
	@Produces(MediaType.TEXT_PLAIN)
	public String getSupportedOperations() {
		return "GET, PUT, POST, DELETE";
	}
	
}