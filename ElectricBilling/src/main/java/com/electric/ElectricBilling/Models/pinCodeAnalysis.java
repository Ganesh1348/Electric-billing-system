package com.electric.ElectricBilling.Models;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class pinCodeAnalysis 
{		private String customerName;
		private Integer customerId;
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
		public Integer getPinCode() {
			return pinCode;
		}
		public void setPinCode(Integer pinCode) {
			this.pinCode = pinCode;
		}
		
}
