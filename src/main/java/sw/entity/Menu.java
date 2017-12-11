package sw.entity;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "t_menu")
public class Menu {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String name;
	
	private String href;
	
//	@ManyToOne
//	@JoinColumn(name="pid")
	private Integer pid;
	
	public Menu(){
		
	}

	public Menu(int id, String name, String href, int pid) {
		super();
		this.id = id;
		this.name = name;
		this.href = href;
		this.pid = pid;
	}
	
	
	
//	@OneToMany(mappedBy="parentMenu",cascade=CascadeType.ALL)
//	private Set<Menu> menus = new HashSet<Menu>();
//	
	//@OneToMany(mappedBy="menu",cascade=CascadeType.ALL)
	//private Set<Action> action = new HashSet<Action>();


	
	

}
