package com.monkmind.digicampus.models;

public enum SubjectGroup {

	GROUP_L("GROUP-L"),
	GROUP_A1("GROUP-A1"),
	GROUP_A2("GROUP-A2"),
	GROUP_S("GROUP-S");
	
	private String group;

	private SubjectGroup(String group) {
		this.group = group;
	}
	public String toString()
	   {
	      return this.group;
	   }
}
