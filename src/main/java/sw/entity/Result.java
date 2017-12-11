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
@Table(name = "t_result")
public class Result {//风险计算结果

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//序号
	
	private Float riskValue;//风险值
	
	private int isAccept;//是否为可接受
	
	@ManyToOne
	@JoinColumn(name="ris_Lev_id")
	private  RiskLevel riskLevel;//风险等级
	
	@ManyToOne
	@JoinColumn(name="weekness_id")
	private Weekness weekness;//所属脆弱性
	
}
