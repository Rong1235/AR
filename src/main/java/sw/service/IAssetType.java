package sw.service;

import java.util.List;

import sw.entity.AssetType;

/**
 * 资产类型管理
 * @author LR
 *
 */
public interface IAssetType {
	
	/**
	 * 查找资产类型
	 * @return
	 */
	public List<AssetType> findAll();

	
}
