package sw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * 资产表
 * @author LR
 *
 */
@Data
@Entity
@Table(name = "t_asset")
public class Asset {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	
	@ManyToOne
	@JoinColumn(name="ass_typ_id")
	private AssetType assetType;
	
	@NotEmpty
	private String name;
	
	private String principle;
	
	private String description;
	
	private float importance;
	
	private String depart;
	
	private String saveForm;
	
	private String backupForm;
	
	private String remark;
}
