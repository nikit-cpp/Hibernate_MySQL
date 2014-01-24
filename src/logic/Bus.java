package logic;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
//import org.hibernate.annotations.;

@Entity
@Table(name = "busses")
public class Bus {

	public Bus() { }
	
	@Id
	@Column(name = "bus_id")
	public Long getId() { return id; }
	public void setId(Long id) { this.id = id; }
	private Long id;

	@Column
	public String getNumber() { return number; }
	public void setNumber(String number) { this.number = number; }
	private String number;
	
	@Column
	public Long getRoute_id() {	return route_id; }
	public void setRoute_id(Long route_id) { this.route_id = route_id; }
	private Long route_id;

    @ManyToMany( targetEntity = logic.Driver.class )
    @JoinTable(
            name="BusDriver",
            joinColumns=@JoinColumn(name="bus_id"),
            inverseJoinColumns=@JoinColumn(name="driver_id")
        )
    public Set getDrivers() { return drivers; }
	public void setDrivers(Set drivers) { this.drivers = drivers; }
	private Set drivers = new HashSet();

}