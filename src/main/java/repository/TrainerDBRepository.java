package repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import domain.Trainee;
import domain.Trainer;

@Default
@Transactional(SUPPORTS)
public class TrainerDBRepository implements TrainerRepository{

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Transactional(REQUIRED)
	public Trainer addTrainer(Trainer t) {
		em.persist(t);
		return t;
	}

	@Transactional(REQUIRED)
	public long deleteTrainer(long id) {
		Trainer toBeDeleted = em.find(Trainer.class, id);
		em.remove(toBeDeleted);
		return id;
	}

	public List<Trainer> getAllTrainers() {
		return em.createQuery("Select all from Trainer all", Trainer.class).getResultList();
	}

	public Trainer findTrainerByID(long id) {
		return em.find(Trainer.class, id);
	}

	@Transactional(REQUIRED)
	public Trainer updateTrainer(Trainer t) {
		Trainer toBeUpdated = em.find(Trainer.class, t);
		toBeUpdated.setFirstName(t.getFirstName());
		toBeUpdated.setLastName(t.getLastName());
		em.merge(toBeUpdated);
		return toBeUpdated;
	}

	public Trainer addTraineeToID(long id, Trainee t) {
		Trainer classRoomUpdated = em.find(Trainer.class, id);
		List<Trainee> temp = classRoomUpdated.getTraineeList();
		temp.add(t);
		classRoomUpdated.setTraineeList(temp);
		return classRoomUpdated;
	}

	public Trainer removeTraineeToID(long id, Trainee t) {
		Trainer classRoomUpdated = em.find(Trainer.class, id);
		List<Trainee> temp = classRoomUpdated.getTraineeList();
		temp.remove(t);
		classRoomUpdated.setTraineeList(temp);
		return classRoomUpdated;
	}

}
