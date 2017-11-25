package sw.service.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sw.dao.UserGroupDao;
import sw.entity.UserGroup;
import sw.model.MUserGroupProject;
import sw.service.IGroupAuthManger;

@Service
public class GroupAuthMangerImpl implements IGroupAuthManger {
	@Autowired
	private UserGroupDao userGroupDao;

	@Override
	public Collection<MUserGroupProject> findAllGroups(Integer projectId) {
		List<UserGroup> userGroupList =  userGroupDao.findByProjectId(projectId);
		Map<String,MUserGroupProject> userGroupMap = new HashMap<String, MUserGroupProject>();
		
		for(UserGroup userGroup : userGroupList){
			String name = userGroup.getGroup().getName();
			if(userGroupMap.keySet().contains(name)){
				MUserGroupProject model = userGroupMap.get(name);
				if(userGroup.getIsHeadman() == 1){//组长
					model.setHeadMan(name);
				}else{//组员
					if(model.getUserNames()==null){
						model.setUserNames(name); 
					}else{ 
						model.setUserNames(model.getUserNames()+","+name);
					}	
				}
			}else{
				MUserGroupProject model = new MUserGroupProject();
				model.setHeadMan(name);
				model.setGroupInfo(userGroup.getGroup().getInfo());
				userGroupMap.put("name", model);
			}
		}
		return userGroupMap.values();
	}

	@Override
	public Integer addUserFromGroup(String userIds, Integer groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteUserFromGroup(Integer userId, Integer groupId) {
		// TODO Auto-generated method stub
		return false;
	}

}
