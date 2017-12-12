package sw.service;

import java.util.List;
import java.util.Map;

import sw.entity.Threat;
import sw.model.MAsset;

/**
 * 资产威胁列表
 * @author LR
 *
 */
public interface IThreatService {
	/**
	 * 通过项目Id查找所有的威胁
	 * @param projectId
	 * @return
	 */
	public Map<String, List<MAsset>> showAllThreads(Integer projectId);
}
