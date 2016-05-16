package model;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "route")
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private int number;

	@OneToMany
	@JoinColumn(name = "route_id")
	private Set<Bus> busses = new HashSet<Bus>();

	public Route() { }

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setBusses(Set busses) {
		this.busses = busses;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}

	public Set<Bus> getBusses() {
		return busses;
	}
}