package Repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Domain.Resource;

public interface IResourceDAO extends JpaRepository<Resource, Integer>{
	public Resource saveAndFlush(Resource arg0);
	List<Resource> findAll();
}