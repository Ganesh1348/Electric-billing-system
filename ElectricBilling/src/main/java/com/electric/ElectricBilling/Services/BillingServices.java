package com.electric.ElectricBilling.Services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.electric.ElectricBilling.Models.userCreate;
import com.electric.ElectricBilling.Models.userDetailsModel;
import com.electric.ElectricBilling.dao.BillingDao;

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

}
