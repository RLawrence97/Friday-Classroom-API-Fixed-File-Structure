package domain;

import javax.persistence.*;

@Entity
public class Trainee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long traineeID;
	private String firstName;
	private String lastName;
	
	public Trainee() {
		
	}
	public Trainee (long id, String fName, String lName) {
		super();
		this.traineeID = id;
		this.firstName=fName;
		this.lastName=lName;
	}

	public Long getTraineeID() {
		return traineeID;
	}

	public void setTraineeID(Long trainerID) {
		this.traineeID = trainerID;
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
	
}
