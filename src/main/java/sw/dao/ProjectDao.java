package sw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Project;

public interface ProjectDao extends CrudRepository<Project, Integer>  {

	 List<Project> findByUserName(String name);
	 List<Project> findByUserId(Integer id);
}
