package sw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sw.dao.AssetDao;
import sw.dao.ProjectDao;
import sw.entity.Asset;
import sw.entity.AssetType;
import sw.service.IAssetService;

@Service
public class AssetServiceImpl implements IAssetService {

	@Autowired
	private AssetDao assetDao;
	
//	@Autowired
//	private AssetType assetType;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public Map<String, List<Asset>> findByprojectIdGroupByType(Integer projectId) {
		List<Asset> assets =assetDao.findByProjectId(projectId);
		if(null == assets) return null;
		Map<String, List<Asset>> assetGroup = new HashMap<String, List<Asset>>();
		 List<Asset> temp;
		for(Asset asset :assets ){
			AssetType type = asset.getAssetType();
			String typeName = type.getName();
			if(assetGroup.containsKey(typeName)){
				temp = assetGroup.get(typeName);
			}else{
				temp = new ArrayList<Asset>();
			}
			temp.add(asset);
			assetGroup.put(typeName, temp);
		}	
		return assetGroup;
	}

	@Override
	public Asset addAsset(Asset asset) {
		
		return assetDao.save(asset);
	}

	@Override
	public Asset updateAsset(Asset asset) {
		return assetDao.save(asset);
	}

	@Override
	public Integer deleteBatch(Integer[] assetIds) {
		for(Integer id : assetIds){
			assetDao.delete(id);
		}
		return null;
	}

}
