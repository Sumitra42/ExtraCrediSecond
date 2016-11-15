package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Domain.*;
import Repository.IProjectDAO;
import Service.ProjectService;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/")
	public String main(Model model){
		setDashboardModel(model);
		return "dashboard";
	}
	
	@RequestMapping(value="/projects_add")
	public String open(Model model){
		Project p = new Project();
		p.setStatus(Status.PENDING);
		model.addAttribute("project", p);
		return "addProject";
	}
	
	@RequestMapping(value="/projects_add", method=RequestMethod.POST)
	public String add(Project project, Model model){
		projectService.save(project);
		setDashboardModel(model);
		return "dashboard";
	}
	
	@RequestMapping(value="/projects_addTask", method=RequestMethod.POST)
	public String addTask(Project project, Task task, Model model){
		project.addTask(task);
		setDashboardModel(model);
		return "dashboard";
	}
	
	@RequestMapping(value="/projects_addBeneficiary", method=RequestMethod.POST)
	public String addBeneficiary(Project project, Beneficiary b, Model model){
		project.addBeneficiary(b);
		setDashboardModel(model);
		return "dashboard";
	}
	
	private void setDashboardModel(Model model){
		model.addAttribute("projectList", projectService.getProjects());
	}
}