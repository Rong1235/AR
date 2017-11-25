package sw.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sw.entity.Asset;

public interface AssetDao extends CrudRepository<Asset, Integer>{
	
	public List<Asset> findByProjectId(Integer projectId);

}
