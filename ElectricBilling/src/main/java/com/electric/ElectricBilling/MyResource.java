
package com.electric.ElectricBilling;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.electric.ElectricBilling.Commands.BillingCommands;
import com.electric.ElectricBilling.Models.pinCodeAnalysis;
import com.electric.ElectricBilling.Models.userCreate;
import com.electric.ElectricBilling.Models.userDetailsModel;
import com.electric.ElectricBilling.Services.BillingServices;
import com.electric.ElectricBilling.dao.BillingDao;

/**
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("/EB")
public class MyResource {

	/**
	 * Method processing HTTP GET requests, producing "text/plain" MIME media type.
	 * 
	 * @return String that will be send back as a response of type "text/plain".
	 */
	@GET
	@Produces("text/plain")
	public String getIt() {
		return "Hi there!";
	}

	@GET
	@Path("/welcome/{pincode}")
	@Produces("text/plain")
	public String getWelcome(@PathParam("pincode") Integer pinCode) {
		String city = null;
		city = BillingServices.getCityNamesServices(pinCode);
		return city;
	}

	@PUT
	@Path("/create/user")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCreateUser(@QueryParam("name") String name, @QueryParam("address") String address,
			@QueryParam("city") String city, @QueryParam("pinCode") Integer pincode)
			throws ClassNotFoundException, SQLException {
		userCreate user = new userCreate();
		user.setCustomerName(name);
		user.setAddress(address);
		user.setCity(city);
		user.setPinCode(pincode);

		String status = null;
		status = BillingServices.getUserDetailsServices(user);
		return status;
	}

	@GET
	@Path("/all/user")	
	@Produces("application/json")
	public List<userDetailsModel> getUserDetails() {

		List<userDetailsModel> userDetails = null;
		try {
			userDetails=BillingServices.getUserInformationServices();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(userDetails);
		return userDetails;

	}
	
	@POST
	@Path("/bill/process")
	@Produces("application/json")
	public String getBillingCustomer(BillingCommands cmd) {
		String billingStatus = null;
		try {
			billingStatus=BillingServices.getUserBillingServices(cmd);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return billingStatus;
	}
	
	
	@GET
	@Path("/analyse/pinCode/{pincode}")
	@Produces("application/json")
	public List<pinCodeAnalysis> getPinCodeAnalysis(@PathParam("pincode") Integer pinCode){
		List<pinCodeAnalysis> analysis = null;
		try {
			analysis=BillingServices.getUserAnalysisServices(pinCode);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return analysis;
	}

}
