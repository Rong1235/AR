package sw.service;

import java.util.List;

import sw.entity.ReferenceFile;

/**
 * 依据文件
 * @author LR
 *
 */
public interface IReferenceFileServie {
	
	/**
	 * 通过项目查找项目依赖文件
	 * @param projectId
	 * @return
	 */
	public List<ReferenceFile> findByProjectId(Integer projectId);
	
	/**
	 * 批量保存项目依据文件
	 * @param projectId
	 * @param refFileId
	 * @return
	 */
	public int  batchSave(Integer projectId,Integer[] refFileIds);
	/**
	 * 批量删除项目依据文件
	 * @param projectId
	 * @param refFileIds
	 * @return
	 */
	public int batchDelete(Integer projectId,Integer[] refFileIds);
	
	/**
	 * 创建依赖文件
	 * @param referenceFile
	 * @return
	 */
	public ReferenceFile save(ReferenceFile referenceFile);
	
	/**
	 * 更新依赖文件
	 * @param referenceFile
	 * @return
	 */
	public ReferenceFile update(ReferenceFile referenceFile);
	
	/**
	 * 通过id查询依赖文件
	 * @param fileId
	 * @return
	 */
	public ReferenceFile findById(Integer fileId);
	
	/**
	 * 批量删除项目依赖文件
	 * @param refFileIds
	 * @return
	 */
	public int deleteBatch(Integer[] refFileIds);
	
	
	


}
