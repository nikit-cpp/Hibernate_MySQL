package logic;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

@Entity
@Table(name = "routes")
public class Route {
	public Route() {
	}

	@Id
	@Column(name = "route_id")
	public Long getId() {return id;}
	public void setId(Long id) {this.id = id;}
	private Long id;
	
	@Column
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	private String name;
	
	@Column
	public int getNumber() {return number;}
	public void setNumber(int number) {this.number = number;}
	private int number;
	
	// ���� �������, ����� ���������
    @OneToMany( targetEntity = logic.Bus.class ) // ������� �����, ������� ����� ������� �� ���������, ������������ ��������
    @JoinColumn(name="bus_id") // ������� ������� busses - ���������, �������������� ������� logic.Bus.class, ���������� ������������ �������� ���������
	public Set getBusses() {return busses;}
	public void setBusses(Set busses) {this.busses = busses;}
	private Set busses = new HashSet();
}