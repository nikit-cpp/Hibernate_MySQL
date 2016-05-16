package model;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "bus")
public class Bus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String number;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "bus_driver",
			joinColumns = { @JoinColumn(name = "bus_id", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "driver_id", nullable = false, updatable = false) }
	)
	private Set<Driver> drivers = new HashSet<Driver>();

	public Bus() {}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void setDrivers(Set drivers) {
		this.drivers = drivers;
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public Set getDrivers() {
		return drivers;
	}
}