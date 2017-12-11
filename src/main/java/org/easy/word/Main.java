package org.easy.word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sw.entity.Project;
import sw.model.MUserGroupProject;

  
public class Main { 
 
	 public static void main(String[] args) throws Exception {
		  Map<String, Object> dataMap = new HashMap<String, Object>(); 
		  Project project = new Project();
		  project.setName("XXX");
		  dataMap.put("project", project); 
		  dataMap.put("time", "test");
		  WordUtils mdoc = new WordUtils(); 
		  String src = "../sw/src/main/resources/model/logo.png";///../src/main/resources/model/logo.png
		  String img = mdoc.getImageBase(src);
		//  dataMap.put("image", img);//图片
		  
		  List<MUserGroupProject> userGroupProjects = new ArrayList<MUserGroupProject>();
		  MUserGroupProject model = new MUserGroupProject();
		  model.setGroupName("资源评估");
		  model.setHeadMan("张三");
		  model.setUserNames("张三，李四");
		  MUserGroupProject model1 = new MUserGroupProject();
		  model1.setGroupName("资源评估1");
		  model1.setHeadMan("张三1");
		  model1.setUserNames("张三，李四1");
		  userGroupProjects.add(model1);
		  userGroupProjects.add(model);
		  dataMap.put("projectUser", userGroupProjects);
		  
		  mdoc.createDoc(dataMap, "E:/outFile.doc");

	}
} 