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
	public List<Project> findCreateProjectByUserId(Integer id);

	/**
	 * 查找该用户参与的项目
	 * 
	 * @param id
	 * @return
	 */
	public Collection<MUserGroupProject> findJoinProjectByUserId(Integer id);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public  Project findById(Integer id);

	/**
	 * 保存项目
	 * @param project
	 * @return
	 */
	public  Project save(Project project);
	
	/**
	 * 修改项目信息
	 * @param project
	 * @return
	 */
	public Project update(Project project);

	/**
	 * 删除项目
	 * @param id
	 * @return
	 */
	public int delete(Integer id);
	
	/**
	 * 设置项目重要资产标准
	 * @param id 项目Id 
	 * @param importance 重要性标准
	 * @return
	 */
	public Integer setImportance(Integer id,Float importance);

}
