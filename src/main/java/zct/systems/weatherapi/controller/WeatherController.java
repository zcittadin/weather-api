package zct.systems.weatherapi.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import zct.systems.weatherapi.model.Weather;
import zct.systems.weatherapi.repository.WeatherRepository;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherRepository weatherRepository;

	@PostMapping("/add")
	public Weather addNewCustomer(@RequestBody Weather newWeather) {
		Weather weather = new Weather();
		weather.setData(LocalDate.now());
		weather.setTime(LocalTime.now());
		weather.setTemp(newWeather.getTemp());
		weather.setUmid(newWeather.getUmid());
		weatherRepository.save(weather);
		return weather;
	}

	@GetMapping("view/all")
	public @ResponseBody Iterable<Weather> getAllCustomers() {
		return weatherRepository.findAll();
	}

	@GetMapping("view/{id}")
	public Optional<Weather> getCustomer(@PathVariable Integer id) {
		return weatherRepository.findById(id);
	}

	@PutMapping("/edit/{id}")
	public String update(@RequestBody Weather updateWeather, @PathVariable Integer id) {
		return weatherRepository.findById(id).map(weather -> {
			weather.setTemp(updateWeather.getTemp());
			weather.setUmid(updateWeather.getUmid());
			weatherRepository.save(weather);
			return "Weather details have been successfully updated!";
		}).orElseGet(() -> {
			return "This weather doesn't exist";
		});
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		weatherRepository.deleteById(id);
		return "Weather has been successfully deleted!";
	}

}
