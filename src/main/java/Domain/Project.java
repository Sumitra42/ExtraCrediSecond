package Domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name;
	private String description;
	private String location;
	
	//@Temporal(TemporalType.DATE)
	private String startDate;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	//@Temporal(TemporalType.DATE)
	private String endDate;
	
	@OneToMany(mappedBy="project", cascade=CascadeType.ALL)
	private List<Task> tasks;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="projects")
	private List<Beneficiary> beneficiaries;

	public Project(){
		this.status = Status.PENDING;
	}
	
	public Project(String name, String description, String location, String startDate, String endDate) {
		this.name = name;
		this.description = description;
		this.location = location;
		this.startDate = startDate;
		this.endDate = endDate;
		this.tasks = new ArrayList<Task>();
		this.beneficiaries = new ArrayList<Beneficiary>();
		this.status = Status.PENDING;
	}
	
	public void addTask(Task task){
		task.setProject(this);
		tasks.add(task);
	}
	
	public void addBeneficiary(Beneficiary b){
		b.addProject(this);
		beneficiaries.add(b);
	}
}
