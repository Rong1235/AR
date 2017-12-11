package sw.dao;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Thread;;

public interface ThreadDao extends CrudRepository<Thread, Integer> {

}
