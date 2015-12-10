package se.team1.cvdb.solution;

//import java.util.ArrayList;
//import java.util.concurrent.atomic.AtomicInteger;


import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;


@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserResource {
	
	 //private static ArrayList<User> userData = new ArrayList<User>();
	// private static AtomicInteger ID_COUNTER = new AtomicInteger();
	 
	 @PUT
	 public void insert(User user){
		 
		 SqlH2 h2 = new SqlH2();
		 h2.initializeConnections();
		 h2.createNewTable();
		 h2.insertRow(user);
		 h2.closeConnections();
		 //return user;
	 }
	 
	@POST
	public void login(User loginCred) throws Exception{
		
		 SqlH2 h2 = new SqlH2();
		 h2.initializeConnections();
		 System.out.println("Email: " + loginCred.getEmail() + ", " + "Password: "+loginCred.getPassword() + ", " +"Designation: " + loginCred.getDesignation());
		 User rs = h2.fetchDetails(loginCred);
		 if(rs.getEmail() == null || rs.getPassword() == null || rs.getDesignation() == null){
			 throw new WebApplicationException(Status.NOT_FOUND);
		 }
		 //return rs;
	}	 
}