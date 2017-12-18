package sw.service.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.easy.excel.ExcelContext;
import org.easy.excel.parsing.ExcelError;
import org.easy.excel.result.ExcelImportResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import sw.dao.AssetDao;
import sw.dao.AssetTypeDao;
import sw.dao.ProjectDao;
import sw.entity.Asset;
import sw.entity.AssetType;
import sw.entity.Project;
import sw.service.IAssetService;

@Service
public class AssetServiceImpl implements IAssetService {

	@Autowired
	private AssetDao assetDao;
	
	@Autowired
	private AssetTypeDao assetTypeDao;
	
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
	public Integer importExcel(String filePath,Integer projectId) throws Exception {
		List<AssetType> types = (List<AssetType>) assetTypeDao.findAll();
		if(null == types || types.size() == 0 ){
			throw new RuntimeException("数据库配置错误！");
		}
		Project project = projectDao.findOne(projectId);
		List<Asset> assetList = new ArrayList<Asset>();
		
		//创建excel上下文实例,它的构成需要配置文件的路径
		ExcelContext context = new ExcelContext("../sw/src/main/resources/excelConfig/Asset.xml");
		for(AssetType assetType :types){
			InputStream excelStream = new FileInputStream(filePath);
			ExcelImportResult result = context.readExcel(assetType.getImportExcel(), 0, excelStream,true);
			//ExcelImportResult result = context.readExcel("FileAndData", 0, excelStream,true);
			if(result.hasErrors()){//导入文件出错
				throw new RuntimeException("数据导入出现错误"+result.getErrors());
			}
			
			List<Asset> assets = result.getListBean();
			if(null == assets || assets.size()==0) continue;
			for(Asset asset:assets){
				asset.setProject(project);
				asset.setAssetType(assetType);
				assetList.add(asset);
			}
			
		}
		assetDao.save(assetList);
		return 0;
	}
	
	@Override
	public Map<String, List<Asset>> findImpProGroupByType(Integer projectId) {
		Project pro = projectDao.findOne(projectId);
		List<Asset> assets =assetDao.findImportantAsset(projectId, pro.getImpStandard());
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
