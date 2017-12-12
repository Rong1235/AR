package sw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Threat;;

public interface ThreatDao extends CrudRepository<Threat, Integer> {
	
	//通过资产Id查找威胁
	public List<Threat> findByAssetId(Integer assetId);

}
