package Domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="User_Role", discriminatorType=DiscriminatorType.STRING)
public abstract class User {
	@Id
	@GeneratedValue
	private int id;
	
	private String name;
	private String password;
	
	@ManyToMany
	private List<Task> tasks;
	
	public User(){}
	
	public User(String name){
		this.name = name;
		tasks = new ArrayList<Task>();
	}
	
	public void addTask(Task t){
		tasks.add(t);
	}
}
