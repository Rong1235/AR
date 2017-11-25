package sw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sw.entity.UserGroup;

public interface UserGroupDao extends CrudRepository<UserGroup, Integer> {  
	
	//通过用户Id查找该用户参与的项目
	public List<UserGroup> findByUserId(Integer userId);
	//通过项目Id查找
	public List<UserGroup> findByProjectId(Integer id);
	
//	@Query("select model * from UserGroup model where model.project.id = ?1 and model.group.name <> ?2")
//	public List<UserGroup> findByProjectId(Integer id,String groupName);

}
