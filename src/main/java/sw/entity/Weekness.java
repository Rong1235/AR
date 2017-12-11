package sw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "t_weekness")
public class Weekness {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//序号
	
	private String name;//脆弱性描述
	
	private Float severity;//脆弱性严重程度
	
	@ManyToOne
	@JoinColumn(name="thread_id")
	private Thread thread;//所属威胁

}
