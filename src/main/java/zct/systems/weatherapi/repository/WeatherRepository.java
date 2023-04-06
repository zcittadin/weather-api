package zct.systems.weatherapi.repository;

import org.springframework.data.repository.CrudRepository;

import zct.systems.weatherapi.model.Weather;


public interface WeatherRepository extends CrudRepository<Weather, Integer> { }
