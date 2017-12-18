package sw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 资产类型表
 * @author LR
 *
 */
@Data
@Entity
@Table(name = "t_asset_type")
public class AssetType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//序号
	
	@NotEmpty
	private String name;//资产类型名称
	
	private String importExcel;//导入excel时对应的工作表名称
	
	//private Integer sheetIndex;//工作表

}
