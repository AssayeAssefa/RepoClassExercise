package com.revature.delegate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.User;
import com.revature.service.UserService;


/*
 * handle the Employee's crud operations
 * 
 */
public class UserDelegate {
	
     UserService uService = new UserService();

	public void getProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ObjectMapper om = new ObjectMapper();

		String idStr = request.getParameter("id");
		System.out.println(idStr);

		String profileJSON;

		if (idStr != null && idStr != "") {
		
		}

		// print my json to the response body of my http response
		PrintWriter pw = response.getWriter();
		//pw.write(profileJSON);
		pw.close();
	}
public void verifyProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	List<User> userArray = new ArrayList<>();
		
		System.out.println("inveriy");
		
		ObjectMapper om = new ObjectMapper();
		
         String requestBodyText = request.getReader().readLine();
	
		
     	User u = om.readValue(requestBodyText, User.class);

	
     
	   
      User foundUser = uService.getByUserName(u.getUsername().toLowerCase());
      
     
      
        if ((foundUser.getUsername() != null) && (foundUser.getPassword().equals(u.getPassword())) ) {
        	
        	System.out.println("verified pass!!!");
        	
        	
        	userArray.add(foundUser);
    	
      	
        }
        PrintWriter pw = response.getWriter();
        pw.write(om.writeValueAsString(userArray));
    	pw.close();
           //  uService.create(u);
	    
	    
	    
	}
	
	public void createProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		System.out.println("inveriy");
		
		ObjectMapper om = new ObjectMapper();
		
         String requestBodyText = request.getReader().readLine();
	
		
     	User u = om.readValue(requestBodyText, User.class);
     	 
     	//set the user name to lower
     	u.setUsername(u.getUsername().toLowerCase());
     	

	
      System.out.println( "--->printing user object" + u);
	   
             uService.create(u);
	    
	    
	    
	}

}
