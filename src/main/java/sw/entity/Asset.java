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

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 资产表
 * @author LR
 *
 */
@Data
@Entity
@Table(name = "t_asset")
@ToString
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//序号
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;//所属项目
	
	@ManyToOne
	@JoinColumn(name="ass_typ_id")
	private AssetType assetType;//资产类型
	
	@NotEmpty
	private String name;//资产名称
	
	private String principle;//负责人
	
	private String description;//描述
	
	private Float importance;//重要性程度
	
	private String depart;//部门
	
	private String saveForm;//存储方式
	
	private String backupForm;//备份方式
	
	private String remark;//备注
	
	private String assetId;//硬件资产编号
	
	private Float integrity;//完整性
	
	private Float availability;//可用性
	
	private Float  confidentiality;//机密性

}
