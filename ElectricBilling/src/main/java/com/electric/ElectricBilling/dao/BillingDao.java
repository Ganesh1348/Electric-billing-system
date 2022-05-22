package com.electric.ElectricBilling.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.electric.ElectricBilling.Models.pinCodeAnalysis;
import com.electric.ElectricBilling.Models.userCreate;
import com.electric.ElectricBilling.Models.userDetailsModel;

import ExecuteQueries.SQLQueries;

public class BillingDao {

	public static String getCityNames(Integer pinCode) {

		if (pinCode == 632521) {
			return "VILLAPAKKAM";
		} else {
			return "ARCOT";
		}

	}

	public static Connection DB() throws ClassNotFoundException {

		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/EBD1?autoReconnect=true&useSSL=false",
					"root", "G@nesh1348");

		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	public static String getUserInsertDao(userCreate user) {
		int status = 0;
		try {
			Connection conn = BillingDao.DB();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO EC1D (customername,address,city,pincode) values (?,?,?,?)");
			ps.setString(1, user.getCustomerName());
			ps.setString(2, user.getAddress());
			ps.setString(3, user.getCity());
			ps.setInt(4, user.getPinCode());

			System.out.println(user.getCustomerName() + user.getAddress() + user.getCity() + user.getPinCode());

			status = ps.executeUpdate();

			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (status > 0) {
			return "User Created Successfully";
		}

		return "User cann't created";
	}

	public static List<userDetailsModel> getUserDetailsDao() 
	{
		List<userDetailsModel> list=new LinkedList<userDetailsModel>();
		try {
			Connection conn=BillingDao.DB();
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM EC1D");
			ResultSet rs=ps.executeQuery();
			
			
			
			while(rs.next()) 
			{
			userDetailsModel userDetails=new userDetailsModel();
			userDetails.setCustomerName(rs.getString(1));
			userDetails.setCustomerId(rs.getInt(2));
			userDetails.setAddress(rs.getString(3));
			userDetails.setCity(rs.getString(4));
			userDetails.setPinCode(rs.getInt(5));
			list.add(userDetails);
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public static String getUserBillingDao(int custId, int EBbill, String occuption) {
	
		int status=0;
		try {
			Connection con = BillingDao.DB();
		PreparedStatement ps = con
				.prepareStatement("INSERT INTO EB1B(customerid,bill,occuption) values(?,?,?)");
		ps.setLong(1,custId);
		ps.setInt(2, EBbill);
		ps.setString(3, occuption);

		status = ps.executeUpdate();
		
		con.commit();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}

	if (status > 0) {
		return "sucessfully inserted";
	}

	return "try again";
}

	public static List<pinCodeAnalysis> exceuteAnalyseDao(Integer pinCode, String town) throws Exception {
		List<userDetailsModel> list=new LinkedList<userDetailsModel>();
		List<pinCodeAnalysis> map=new ArrayList<pinCodeAnalysis>();
		try {
			Connection conn=BillingDao.DB();
			PreparedStatement ps=conn.prepareStatement(SQLQueries.USER_DETAILS);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				userDetailsModel model=new userDetailsModel();
				model.setCustomerName(rs.getString(1));
				model.setCustomerId(rs.getInt(2));
				model.setPinCode(rs.getInt(5));
				list.add(model);				
			}
			conn.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		map=BillingDao.executeAnalyseDao(list,pinCode);
		return map;
	}
	
	@SuppressWarnings("unchecked")
	public static List<pinCodeAnalysis> executeAnalyseDao(List<userDetailsModel> model,Integer pinCode) throws Exception{
		List<pinCodeAnalysis> result=new ArrayList<pinCodeAnalysis>();
		
		 ListIterator<userDetailsModel> list= model.listIterator();
		 
		 while(list.hasNext()) {
			System.out.println(list.next());
		 }
		 
		 for(userDetailsModel user:model) 
		 {
			 pinCodeAnalysis pin=new pinCodeAnalysis();
			 if(user.getPinCode().equals(pinCode)) {
				 pin.setCustomerId(user.getCustomerId());
				 pin.setCustomerName(user.getCustomerName());
				 pin.setPinCode(user.getPinCode());
				 result.add(pin);				 
			 }
		 }
		
		return result;
	}

}
