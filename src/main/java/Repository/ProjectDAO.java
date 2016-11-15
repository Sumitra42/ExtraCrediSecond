package Repository;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import Domain.Beneficiary;
import Domain.Project;
import Domain.Task;

@Repository
@Deprecated
public class ProjectDAO  {

	//@Resource
	private SessionFactory sf;
	
	public SessionFactory getSf() {
		return sf;
	}

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void addProject(Project p) {
		sf.getCurrentSession().persist(p);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void editProject(Project p) {
		sf.getCurrentSession().merge(p);
	}

	public void addTask(Project p, Task t) {
		p.addTask(t);
	}

	public void addBeneficiary(Project p, Beneficiary b) {
		p.addBeneficiary(b);
	}

}