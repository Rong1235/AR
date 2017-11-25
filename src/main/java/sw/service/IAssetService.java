package sw.service;

import java.util.List;
import java.util.Map;

import sw.entity.Asset;
/**
 * 资产管理
 * @author LR
 *
 */
public interface IAssetService {
	
	/**
	 * 通过项目Id查找资产
	 * @param projectId
	 * @return
	 */
	public Map<String, List<Asset>> findByprojectIdGroupByType(Integer projectId);
	
	/**
	 * 添加资产
	 * @param asset
	 * @return
	 */
	public Asset addAsset(Asset asset);
	
	/**
	 * 修改资产
	 * @param asset
	 * @return
	 */
	public Asset updateAsset(Asset asset);
	
	
	/**
	 * 批量删除
	 * @param assetIds
	 * @return
	 */
	public Integer deleteBatch(Integer[] assetIds);
	
	

}
