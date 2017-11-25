package sw.model;

import java.util.Date;

import lombok.Data;

@Data
public class MUserGroupProject {
	private Integer projectId;//所属项目Id
	private String projectName;//所属项目名称
	private Date createDate;//项目创建时间
	private String projectInfo;//所属项目简介
	private String groupIds;//用户组Id
	private String groupName;//用户组名
	private String userNames;//包含成员
	private String headMan;//组长
	private String groupInfo;//小组信息
}
