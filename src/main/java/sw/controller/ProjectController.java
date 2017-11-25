package sw.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sw.entity.Project;
import sw.model.MMenu;
import sw.model.MUserGroupProject;
import sw.service.IGroupAuthManger;
import sw.service.ILeftMenuService;
import sw.service.IProjectService;

@Controller
@RequestMapping("/pro")
public class ProjectController {

	@Autowired
	private IProjectService projectService;
	
	@Autowired
	private ILeftMenuService leftMenuServiceImpl;
	
	@Autowired
	private IGroupAuthManger groupAuthService;
	
	/**
	 * 显示我创建的项目列表
	 * @param model
	 * @return
	 */
	@GetMapping("/projectList")
	public String showProjectPage(Model model){
		List<Project> projects = projectService.findCreateProjectByUserId(1);
		Collection<MUserGroupProject> joinProjects = projectService.findJoinProjectByUserId(1);
		model.addAttribute("projects", projects);
		model.addAttribute("joinProjects",joinProjects);
		return "/pages/project/ProjectList";
	}
	
	
	@GetMapping("/projectForm")
	public String showProjectFormView(Model model){
		model.addAttribute("project",new Project());
		return "/pages/project/ProjectForm";
	}
	
	@PostMapping("/projectAdd")
	public String projectAdd( @ModelAttribute("project")Project project,Model model){
		model.addAttribute("addResult",projectService.save(project));
		return "/pages/project/ProjectForm";
	}
	
	
	@GetMapping("/projectForm/{id}")
	public String showProjectForm(@PathVariable int id,Model model){
	Project project = projectService.findById(id);
		model.addAttribute("project", project);
		model.addAttribute("operation","update");
		return "/pages/project/ProjectForm";
	}
	
	
	@PostMapping("/updateProject")
	public String updateProject( @ModelAttribute("project")Project project){
		projectService.save(project);
		return "redirect:/pro/projectList";
	}
	
	@GetMapping("/delProject/{id}")
	public String delCollege(@PathVariable int id){
		projectService.delete(id);
		return "redirect:/pro/projectList";
	}

	
	@RequestMapping("/menu")
	@ResponseBody
	public MMenu findByroot(){
		MMenu menu = leftMenuServiceImpl.findMenuByRoot(8);
		return menu;
	}

	@GetMapping("/findAllGroups/{projectId}")
	public void  findAllGroups(@PathVariable int projectId,Model model){
	    Collection<MUserGroupProject> groups = groupAuthService.findAllGroups(projectId);
	    model.addAttribute("authGroups",groups);
	}
	
	/**
	 * 显示我参与的项目的详细内容
	 * @param projectId
	 * @param groupIds
	 * @param model
	 * @return
	 */
	@GetMapping("/projectMain/{projectId}/{groupIds}")
	public String showProjectMain(@PathVariable int projectId,@PathVariable String groupIds,Model model){
	    String[] groupArr = groupIds.split(",");
	    List<MMenu> menuList = new ArrayList<MMenu>();
	    for(String groupId : groupArr){
	    	MMenu menu = leftMenuServiceImpl.findMenuByRoot(Integer.valueOf(groupId));
	    	menuList.add(menu);
	    }
		model.addAttribute("projectId", projectId);
		model.addAttribute("menuList",menuList);
		return "/pages/project/ProjectMain";
	}
}
