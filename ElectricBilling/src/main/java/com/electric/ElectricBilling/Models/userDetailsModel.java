package com.electric.ElectricBilling.Models;

import javax.xml.bind.annotation.XmlRootElement;

import com.electric.ElectricBilling.SerializedName;

@XmlRootElement
public class userDetailsModel {
	
//	@SerializedName("custName")
//	@Expose
	private String customerName;
//	
//	@SerializedName("ID")
//	@Expose
	private Integer customerId;
	
//	@SerializedName("ADD")
//	@Expose
	private String address;
//	
//	@SerializedName("TOWN")
//	@Expose
	private String city;
//	
//	@SerializedName("PINCODE")
//	@Expose
	private Integer pinCode;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}
	
	@Override
	public String toString() {
		return getCustomerName() + ' ' +getCustomerId();
	}

}
