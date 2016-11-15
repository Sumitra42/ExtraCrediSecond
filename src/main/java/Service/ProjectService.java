package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import Domain.Project;
import Domain.Task;
import Repository.IProjectDAO;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ProjectService {

	@Autowired
	private IProjectDAO projectDAO;
	
	public void save(Project p){
		projectDAO.saveAndFlush(p);
	}
	
	public List<Project> getProjects(){
		return projectDAO.findAll();
	}
	
	public List<Task> getTasks(int projectId){
		return projectDAO.findOneById(projectId).getTasks();
	}
}
