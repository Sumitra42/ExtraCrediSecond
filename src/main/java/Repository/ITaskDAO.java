package Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Domain.Resource;
import Domain.Task;

public interface ITaskDAO extends JpaRepository<Task, Integer>{
	public Task saveAndFlush(Task arg0);
	public List<Task> findAll();
	public List<Task> findByProject_Id(int id);
}