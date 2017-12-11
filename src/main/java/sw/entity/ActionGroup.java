package sw.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "t_actiongroup")
public class ActionGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="action_id")
	private Action action;
	
	@ManyToOne
	@JoinColumn(name="group_id")
	private Group group;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User modifyUser;
	
	private Timestamp createDate;

	@ManyToOne
	@JoinColumn(name="menu_id")
	private Menu menu;
	
}
