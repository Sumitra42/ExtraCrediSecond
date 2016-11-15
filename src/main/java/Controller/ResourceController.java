package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Domain.Project;
import Domain.Resource;
import Repository.IProjectDAO;
import Repository.IResourceDAO;

@Controller
public class ResourceController {
	
	@Autowired
	private IResourceDAO resourceDAO;
	
	@Autowired
	private IProjectDAO projectDAO;
	
	@RequestMapping(value="/resources_add")
	public String open(Model model){
		Resource p = new Resource();
		model.addAttribute("resource", p);
		return "addResource";
	}
	
	@RequestMapping(value="/resources_add", method=RequestMethod.POST)
	public String add(Resource resource, Model model){
		resourceDAO.saveAndFlush(resource);
		setDashboardModel(model);
		return "dashboard";
	}
	
	private void setDashboardModel(Model model){
		model.addAttribute("projectList", projectDAO.findAll());
	}
}