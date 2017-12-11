package sw.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import sw.entity.Asset;

public interface AssetDao extends CrudRepository<Asset, Integer>{
	
	public List<Asset> findByProjectId(Integer projectId);
	
	@Query("select model from Asset model where model.projectId =?1 and importance >= ?2")
	public List<Asset> findImportantAsset(Integer projectId,Float importance);
	
}
