package zct.systems.weatherapi.model;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "weather")
@Entity
public class Weather {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "data")
	private LocalDate data;
	@Column(name = "time")
	private LocalTime time;
	@Column(name = "temp")
	private Double temp;
	@Column(name = "umid")
	private Double umid;

	public Integer getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTemp() {
		return temp;
	}

	public void setTemp(Double temp) {
		this.temp = temp;
	}

	public Double getUmid() {
		return umid;
	}

	public void setUmid(Double umid) {
		this.umid = umid;
	}

}
