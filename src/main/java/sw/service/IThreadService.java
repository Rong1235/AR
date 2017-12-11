package sw.service;

import java.util.List;

/**
 * 资产威胁列表
 * @author LR
 *
 */
public interface IThreadService {

	/**
	 * 通过项目Id查找所有的威胁
	 * @param projectId
	 * @return
	 */
	public List<Thread> showAllThreads(Integer projectId);
}
