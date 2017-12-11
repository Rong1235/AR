package sw.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "t_project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//序号
	@NotNull
	private String name;//项目名称
	
	private String description;//项目概述
	
	private String range;//评估范围
	
	private String gplot;//网络拓扑图
	
	//@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;//创建时间
	
	
	private Float impStandard;//重要资产标准
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;//负责人

	
}
