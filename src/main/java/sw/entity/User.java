package sw.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "t_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String password;
	@NotNull
	private String name;
	private String email;
	private String tel;
//	@OneToMany(mappedBy="modifyUser",cascade=CascadeType.ALL)
//	private Set<Group> groups = new HashSet<Group>();
	
	
	
}
