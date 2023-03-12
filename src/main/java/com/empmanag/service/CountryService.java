package com.empmanag.service;

import java.util.List;

import com.empmanag.entity.Country;

public interface CountryService 
{

	public boolean addCountry(Country country);

	public boolean updateCountry(Country country);

	public Country getCountryById(int cId);

	public Country deleteCountryById(int cId);

	public List<Country> getAllCountries();
	

}
