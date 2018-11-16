package domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Trainer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trainerID;
	private String firstName;
	private String lastName;
	@OneToMany (cascade =CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Trainee> traineeList;
	
	public Trainer() {
		traineeList = new ArrayList<Trainee>();
	}
	
	public Trainer (long id, String fName, String lName, List<Trainee> incTList) {
		super();
		this.trainerID = id;
		this.firstName=fName;
		this.lastName=lName;
		this.traineeList=incTList;
	}
	public Long getTrainerID() {
		return trainerID;
	}
	public void setTrainerID(Long trainerID) {
		this.trainerID = trainerID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<Trainee> getTraineeList() {
		return traineeList;
	}
	public void setTraineeList(List<Trainee> traineeList) {
		this.traineeList = traineeList;
	}
	
}
