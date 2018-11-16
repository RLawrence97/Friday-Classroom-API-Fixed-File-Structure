package domain;

import java.util.List;

import javax.persistence.*;

@Entity
public class Trainer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long trainerID;
	private String firstName;
	private String lastName;
	@OneToMany
	private List<Trainee> traineeList;
	
	public Trainer() {
		
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
