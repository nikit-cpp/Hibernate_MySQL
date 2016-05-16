package model;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@Table(name = "driver")
public class Driver {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	private String surname;

	private int age;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "drivers")
	private Set<Bus> busses = new HashSet<Bus>();

	public Driver() { }

	public void setBusses(Set busses) {
		this.busses = busses;
	}

	public Set getBusses() {
		return busses;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public int getAge() {
		return age;
	}
}