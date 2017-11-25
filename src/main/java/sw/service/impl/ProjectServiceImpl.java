package sw.service.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sw.dao.ProjectDao;
import sw.dao.UserGroupDao;
import sw.entity.Group;
import sw.entity.Project;
import sw.entity.UserGroup;
import sw.model.MUserGroupProject;
import sw.service.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private UserGroupDao userGroupDao;

	@Override
	public List<Project> findCreateProjectByUserId(Integer id) {
		if(null == id) return null;
		return projectDao.findByUserId(id);
	}
	
	@Override
	public Collection<MUserGroupProject> findJoinProjectByUserId(Integer userId) {
		if(null == userId) return null;
		List<UserGroup> userGroups = userGroupDao.findByUserId(userId);
		Map<Integer,MUserGroupProject> joinProjectList=new HashMap<Integer,MUserGroupProject>();
		for(UserGroup userGroup :userGroups){
			MUserGroupProject model ;
			Project pro = userGroup.getProject();
			Group group = userGroup.getGroup();
			if(joinProjectList.containsKey(pro.getId())){
				model = joinProjectList.get(pro.getId());
				model.setGroupName(model.getGroupName()+","+group.getName());
				model.setGroupIds(model.getGroupIds() + ","+group.getId());
			}else{
				model = new MUserGroupProject();
				model.setProjectId(pro.getId());
				model.setProjectName(pro.getName());
				model.setCreateDate(pro.getCreateDate());
				model.setProjectInfo(pro.getDescription());	
				model.setGroupName(group.getName());
				model.setGroupIds(group.getId()+"");
			}
			joinProjectList.put(pro.getId(), model);		
		}
		return joinProjectList.values();
	}
	
	@Override
	public Project findById(Integer id) {
		if(null == id) return null;
		return projectDao.findOne(id);
	}
	@Override
	public int save(Project project) {
			project.setCreateDate(new Date());
		 Project pro = projectDao.save(project);
		 
		 if(pro != null) return 1;
		return 0;
	}
	
	public int delete(Integer id) {
		if(null == id) return 0;
	    try {
			projectDao.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}	
}
