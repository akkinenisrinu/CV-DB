package se.team1.cvdb.solution;

//import java.util.ArrayList;
//import java.util.concurrent.atomic.AtomicInteger;


import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/user")
public class UserResource {
	
	 //private static ArrayList<User> userData = new ArrayList<User>();
	// private static AtomicInteger ID_COUNTER = new AtomicInteger();
	 
	 @PUT
	 public User insert(User user){
		 
		 SqlH2 h2 = new SqlH2();
		 h2.initializeConnections();
		 h2.createNewTable();
		 h2.insertRow(user);
		 h2.closeConnections();
		 return user;
	 }
}