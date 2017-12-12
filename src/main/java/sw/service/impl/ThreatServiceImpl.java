package sw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sw.dao.AssetDao;
import sw.dao.ProjectDao;
import sw.dao.ThreatDao;
import sw.entity.Asset;
import sw.entity.AssetType;
import sw.entity.Project;
import sw.entity.Threat;
import sw.model.MAsset;
import sw.service.IThreatService;

@Service
public class ThreatServiceImpl implements IThreatService  {
	
	@Autowired
	private ProjectDao proDao;
	
	@Autowired
	private AssetDao assetDao;
	
	@Autowired
	private ThreatDao  threadDao;

	@Override
	public Map<String, List<MAsset>> showAllThreads(Integer projectId) {
		Project pro = proDao.findOne(projectId);
		List<Asset> assets =assetDao.findImportantAsset(projectId, pro.getImpStandard());
		if(null == assets) return null;
		Map<String, List<MAsset>> assetGroup = new HashMap<String, List<MAsset>>();
		 List<MAsset> temp;
		for(Asset asset :assets ){
			AssetType type = asset.getAssetType();
			String typeName = type.getName();
			if(assetGroup.containsKey(typeName)){
				temp = assetGroup.get(typeName);
			}else{
				temp = new ArrayList<MAsset>();
			}
			List<Threat> threaList = threadDao.findByAssetId(asset.getId());
			MAsset model = new MAsset(asset,threaList);
			temp.add(model);
			assetGroup.put(typeName, temp);
		}	
		return assetGroup;
	}

}
