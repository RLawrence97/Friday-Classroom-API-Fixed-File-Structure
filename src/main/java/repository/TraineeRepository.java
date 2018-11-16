package repository;

import java.util.List;

import domain.Trainee;

public interface TraineeRepository {
	public Trainee addTrainee(Trainee t);
	public long deleteTrainee(long id);
	public List<Trainee> getAllTrainees();
	public Trainee findTraineeByID(long id);
	public Trainee updateTrainee(Trainee t);
}
