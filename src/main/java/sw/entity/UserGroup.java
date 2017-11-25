package sw.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "t_usergroup")
public class UserGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	private Group group;
	
	private int isHeadman;//是否是组长
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@OneToOne
	@JoinColumn(name="modify_userid")
	private User modifyUser;
	
	
	private Timestamp createDate;

	
	
}
