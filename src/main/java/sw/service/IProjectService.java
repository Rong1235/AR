package sw.service;

import java.util.Collection;
import java.util.List;

import sw.entity.Project;
import sw.model.MUserGroupProject;

public interface IProjectService {

	/**
	 * 查找该用户创建的项目
	 * 
	 * @param id
	 * @return
	 */
	List<Project> findCreateProjectByUserId(Integer id);

	/**
	 * 查找该用户参与的项目
	 * 
	 * @param id
	 * @return
	 */
	Collection<MUserGroupProject> findJoinProjectByUserId(Integer id);

	Project findById(Integer id);

	int save(Project project);

	int delete(Integer id);
}
