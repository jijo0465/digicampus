package com.monkmind.digicampus.models;

public enum BloodGroup {
	
	O_POS("O+"),
	O_NEG("O-"),
	A_POS("A+"),
	A_NEG("A-"),
	B_POS("B+"),
	B_NEG("B-"),
	AB_POS("AB+"),
	AB_NEG("AB-"),
	NO_ANSWER("NA");

	private String group;

	private BloodGroup(String group) {
		this.group = group;
	}
	public String toString()
	   {
	      return this.group;
	   }
}
