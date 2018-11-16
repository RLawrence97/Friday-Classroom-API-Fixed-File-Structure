package rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.BusinessLogic;
import domain.Trainee;
import domain.Trainer;

@Path("/classroom")
public class Interoperability {
	@Inject
	private BusinessLogic bl;
	
	@GET
	@Path("/alltrainers")
	@Produces({ "application/json" })
	public String getAllTrainers() {
		return bl.getAllTrainers();
	}
	
	@GET
	@Path("/alltrainees")
	@Produces({ "application/json" })
	public String getAllTrainees() {
		return bl.getAllTrainee();
	}
	
	@GET
	@Path("/trainer/{id}")
	@Produces({ "application/json" })
	public String getTrainerByID(@PathParam("id") long incomingID) {
		return bl.getTrainerByID(incomingID);
	}
	@GET
	@Path("/trainee/{id}")
	@Produces({ "application/json" })
	public String getTraineeByID(@PathParam("id") long incomingID) {
		return bl.getTraineeByID(incomingID);
	}
	
	@DELETE
	@Path("/removetrainer/{remove}")
	@Produces({ "application/json" })
	public String deleteTrainer(@PathParam("remove") long incomingID) {
		return bl.deleteTrainer(incomingID);
	}
	
	@DELETE
	@Path("/removetrainee/{remove}")
	@Produces({ "application/json" })
	@Consumes({ "application/json" })
	public String deleteTrainee(@PathParam("remove") long incomingID, Trainee inc) {
		return bl.deleteTrainee(incomingID, inc);
	}
	
	@PUT
	@Path("/updatetrainer")
	@Produces({"application/json"})
	@Consumes({ "application/json" })
	public String update(Trainer incoming) {
		return bl.updateByTrainer(incoming);
	}
	
	@PUT
	@Path("/updatetrainee")
	@Produces({"application/json"})
	public String update(Trainee incoming) {
		return bl.updateByTrainee(incoming);
	}
	
	@POST
	@Path("/addtrainer")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public String addTrainer(Trainer c) {
		return bl.addTrainer(c);
	}
	
	@POST
	@Path("/addtrainee/{id}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public String addTrainee(Trainee c) {
		return bl.addTrainee(c);
	}
	
	@POST
	@Path("/addtraineeto/{id}")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public String addToClassRoom(@PathParam("id") long id, Trainee c) {
		return bl.addTraineeToClass(id, c);
	}
	
	@GET
	@Path("/numberofstudents/{id}")
	@Produces({" application/json "})
	public String getNumberOfStudents(@PathParam("id") long id) {
		return bl.numberOfStudentsByID(id);
	}
}
