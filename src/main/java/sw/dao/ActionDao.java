package sw.dao;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Action;

public interface ActionDao extends CrudRepository<Action, Integer> {  
	  

}
