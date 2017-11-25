package sw.dao;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Group;

public interface GroupDao extends CrudRepository<Group, Integer> {  
	  

}
