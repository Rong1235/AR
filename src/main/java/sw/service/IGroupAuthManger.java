package sw.service;

import java.util.Collection;
import java.util.List;

import sw.entity.Group;
import sw.model.MUserGroupProject;

/**
 * 组权限管理
 * @author LR
 *
 */
public interface IGroupAuthManger {

	/**
	 * 通过项目Id查看所有的权限组
	 * @return
	 */
	public Collection<MUserGroupProject> findAllGroups(Integer projectId);

	
	/**
	 * 将用户添加到某个组
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public Integer addUserFromGroup(String userIds,Integer groupId);
	
	/**
	 * 将用户从某个组移除
	 * @param userId
	 * @param groupId
	 * @return
	 */
	public boolean deleteUserFromGroup(Integer userId,Integer groupId);
	
	

}
