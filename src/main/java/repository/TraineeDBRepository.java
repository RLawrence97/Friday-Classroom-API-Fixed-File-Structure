package repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import domain.Trainee;


@Default
@Transactional(SUPPORTS)
public class TraineeDBRepository implements TraineeRepository{

	@PersistenceContext(unitName = "primary", type=PersistenceContextType.EXTENDED)
	private EntityManager em;
	
	@Transactional(REQUIRED)
	public Trainee addTrainee(Trainee t) {
		em.persist(t);
		return t;
	}

	@Transactional(REQUIRED)
	public long deleteTrainee(long id) {
		Trainee toBeDeleted = em.find(Trainee.class, id);
		em.remove(toBeDeleted);
		return id;
	}

	public List<Trainee> getAllTrainees() {
		return em.createQuery("Select t from Trainee t", Trainee.class).getResultList();
	}

	public Trainee findTraineeByID(long id) {
		return em.find(Trainee.class, id);
	}

	@Transactional(REQUIRED)
	public Trainee updateTrainee(Trainee t) {
		Trainee toBeUpdated = em.find(Trainee.class, t.getTraineeID());
		if (toBeUpdated != null) {
			toBeUpdated = t;
			em.merge(toBeUpdated);
		}
		return toBeUpdated;
	}

}
