package com.weather.lookup.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weather.lookup.app.domain.WeatherInfo;

@Repository
public interface WeatherLookupRepository extends JpaRepository<WeatherInfo, Long>{
	
	 List<WeatherInfo> findFirst5ByCityContainingOrderByCreatedDesc(String city);

}
