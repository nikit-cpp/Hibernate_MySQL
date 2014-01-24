package logic;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

// TODO Если закомментировать - то вместе с ошибкой получаем висячий поток. FIX IT
@Entity
@Table(name = "drivers")
public class Driver {
	public Driver() {
	}

	@Id
	@Column(name = "driver_id")
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	private Long id;

	@Column
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	private String name;

	@Column
	public String getSurname() { return surname; }
	public void setSurname(String surname) { this.surname = surname; }
	private String surname;

	@Column
	public int getAge() { return age; }
	public void setAge(int age) { this.age = age; }
	private int age;
	
	// Сущности Водитель и Автобус относятся как "многие-ко-многим"
    @ManyToMany( targetEntity = logic.Bus.class ) // Целевой класс, который будет помещён во множество, возвращаемое геттером
    @JoinTable(
            name="BusDriver",
            joinColumns=@JoinColumn(name="driver_id"), // Столбец <key column="driver_id" /> в Таблице соединения, представляющий этот класс
            inverseJoinColumns=@JoinColumn(name="bus_id") // ... столбец, из которого выбираются автобусы
    )
	public Set getBusses() { return busses; }
	public void setBusses(Set busses) { this.busses = busses; }
	private Set busses = new HashSet();

}