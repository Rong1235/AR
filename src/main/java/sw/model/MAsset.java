package sw.model;

import java.util.List;

import lombok.Data;
import sw.entity.Asset;
import sw.entity.Project;
import sw.entity.Threat;

/**
 * 资产model
 * @author LR
 *
 */
@Data
public class MAsset {

	private Integer id;//序号
	private Project project;//所属项目
	private Integer assetTypeId;//资产类型编号
	private String assetType;//资产类型
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
	private List<MThread> thread;

	public MAsset(Asset asset, List<Threat> threaList) {
		this.id = asset.getId();
		this.name = asset.getName();
	}



}
