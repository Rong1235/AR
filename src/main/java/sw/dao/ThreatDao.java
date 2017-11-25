package sw.dao;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Threat;;

public interface ThreatDao extends CrudRepository<Threat, Integer> {

}
