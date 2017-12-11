package sw.model;

import java.util.List;

import sw.entity.RiskLevel;
import lombok.Data;

@Data
public class MWeakness {
	private Integer id;//序号
	private String name;//脆弱性描述
	private Float severity;//脆弱性严重程度
	
	private Float riskValue;//风险值
	private int isAccept;//是否为可接受
	private  RiskLevel riskLevel;//风险等级
}
