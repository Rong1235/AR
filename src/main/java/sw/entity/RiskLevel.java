package sw.entity;

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
@Table(name = "t_risk_level")
public class RiskLevel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//序号
	
	private String name;//风险等级名称
	
	private Float minValue;//最小值
	
	private Float maxValue;//最大值
	
	private String description;//描述
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;//所属项目
}
