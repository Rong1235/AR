package sw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Menu;

public interface MenuDao extends CrudRepository<Menu, Integer> {  
	  
	public List<Menu> findByPid(Integer pid);

}
