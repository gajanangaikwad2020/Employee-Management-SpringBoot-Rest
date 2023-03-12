package com.empmanag.serviceIMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmanag.dao.CountryDao;
import com.empmanag.entity.Country;
import com.empmanag.service.CountryService;
@Service
public class CountryServiceIMPL implements CountryService
{
	@Autowired
	private CountryDao countryDao;
	
	@Override
	public boolean addCountry(Country country) {
		
		return countryDao.addCountry(country) ;
	}

	@Override
	public Country getCountryById(int cId) {
	
		return countryDao.getCountryById(cId);
	}

	@Override
	public boolean updateCountry(Country country) 
	{
		
		return countryDao.updateCountry(country);
	}

	@Override
	public Country deleteCountryById(int cId) 
	{
		return countryDao.deleteCountryById(cId);
	}

	
	@Override
	public List<Country> getAllCountries() 
	{
		
		return countryDao.getAllCountries();
	}	

}
