package com.empmanag.dao;

import java.util.List;

import com.empmanag.entity.Country;

public interface CountryDao 
{

	public boolean addCountry(Country country);

	public Country getCountryById(int empId);

	public boolean updateCountry(Country country);

	public Country deleteCountryById(int empId);

	public List<Country> getAllCountries();
	

}
