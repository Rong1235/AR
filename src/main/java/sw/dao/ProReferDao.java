package sw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sw.entity.ProRef;

public interface ProReferDao extends CrudRepository<ProRef, Integer>  {
	
	public List<ProRef> findByProjectId(int projectId);

}
