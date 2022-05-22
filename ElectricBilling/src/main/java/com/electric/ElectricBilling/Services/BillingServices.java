package com.electric.ElectricBilling.Services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.electric.ElectricBilling.Commands.BillingCommands;
import com.electric.ElectricBilling.Models.pinCodeAnalysis;
import com.electric.ElectricBilling.Models.userCreate;
import com.electric.ElectricBilling.Models.userDetailsModel;
import com.electric.ElectricBilling.dao.BillingDao;

import ExecuteQueries.pinCodeDetails;

public class BillingServices {

	public static String getCityNamesServices(Integer pinCode) {

		return BillingDao.getCityNames(pinCode);
	}

	public static String getUserDetailsServices(userCreate user) throws ClassNotFoundException, SQLException {

		return BillingDao.getUserInsertDao(user);
	}

	public static List<userDetailsModel> getUserInformationServices() {
		
		return BillingDao.getUserDetailsDao();
	}

	public static String getUserBillingServices(BillingCommands cmd) {
		String occuption = cmd.getOccuption();
		int custId=cmd.getCustomerInt();
		int EBbill=0;
		if(cmd.getOccuption().equalsIgnoreCase("Handloom"))
		{
			EBbill=cmd.getBill()/100*50;
		}
		else {
			EBbill=cmd.getBill();
		}
		return BillingDao.getUserBillingDao(custId,EBbill,occuption);
	}

	public static List<pinCodeAnalysis> getUserAnalysisServices(Integer pinCode)throws Exception {
		String Town=null;
		try {
			Town=pinCodeDetails.pinCodeCities(pinCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return BillingDao.exceuteAnalyseDao(pinCode,Town);
	}

}
