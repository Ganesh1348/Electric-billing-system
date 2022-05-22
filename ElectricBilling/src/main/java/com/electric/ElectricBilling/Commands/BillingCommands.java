package com.electric.ElectricBilling.Commands;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BillingCommands 
{
private Integer customerInt;
private Integer bill;
private String occuption;
public Integer getCustomerInt() {
	return customerInt;
}
public void setCustomerInt(Integer customerInt) {
	this.customerInt = customerInt;
}
public Integer getBill() {
	return bill;
}
public void setBill(Integer bill) {
	this.bill = bill;
}
public String getOccuption() {
	return occuption;
}
public void setOccuption(String occuption) {
	this.occuption = occuption;
}


}
