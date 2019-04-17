package com.xpf.pojo;

import java.util.List;

public class UserQuarterCityMap {

	private String quarter;
	private List<City> citys;
	public UserQuarterCityMap() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserQuarterCityMap(String quarter, List<City> citys) {
		super();
		this.quarter = quarter;
		this.citys = citys;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	@Override
	public String toString() {
		return "UserQuarterCityMap [quarter=" + quarter + ", citys=" + citys
				+ "]";
	}
	
	
}
