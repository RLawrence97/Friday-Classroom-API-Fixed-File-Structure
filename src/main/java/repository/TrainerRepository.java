package repository;

import java.util.List;

import domain.Trainee;
import domain.Trainer;

public interface TrainerRepository {
	public Trainer addTrainer(Trainer t);
	public long deleteTrainer(long id);
	public List<Trainer> getAllTrainers();
	public Trainer findTrainerByID(long id);
	public Trainer updateTrainer(Trainer t);
	public Trainer addTraineeToID(long id, Trainee t);
	public Trainer removeTraineeToID(long id, Trainee t);

}
