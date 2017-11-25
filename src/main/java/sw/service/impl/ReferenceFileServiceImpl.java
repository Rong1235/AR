package sw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sw.dao.ProReferDao;
import sw.dao.ProjectDao;
import sw.dao.ReferenceFileDao;
import sw.entity.ProRef;
import sw.entity.ReferenceFile;
import sw.service.IReferenceFileServie;

@Service
public class ReferenceFileServiceImpl implements IReferenceFileServie {

	@Autowired
	private ProReferDao proReferDao;
	
	@Autowired
	private ProjectDao projectDao;
	
	@Autowired
	private ReferenceFileDao referenceFileDao;

	@Override
	public List<ReferenceFile> findByProjectId(Integer projectId) {
		 List<ProRef> refFiles = proReferDao.findByProjectId(projectId);
		 List<ReferenceFile> files = new ArrayList<ReferenceFile>();
		 for(ProRef ref :refFiles){
			 files.add(ref.getReferenceFile());
		 }
		 return files;
	}
	
	@Override
	public int batchSave(Integer projectId, Integer[] refFileIds) {
		if(null == refFileIds) return -1;
		List<ProRef> proRefList = new ArrayList<ProRef>();
		for(Integer id : refFileIds){
			ProRef ref = new ProRef();
			ref.setProject(projectDao.findOne(projectId));
			ref.setReferenceFile(referenceFileDao.findOne(id));
			proRefList.add(ref);
		}
		proReferDao.save(proRefList);
		return 0;
	}

	@Override
	public int batchDelete(Integer projectId, Integer[] refFileIds) {
		if(null == refFileIds) return -1;
		for(Integer id : refFileIds){
			proReferDao.delete(id);
		}
		return 0;
	}

	@Override
	public ReferenceFile save(ReferenceFile referenceFile) {
	    ReferenceFile file = referenceFileDao.save(referenceFile);
		return file;
	}

	@Override
	public ReferenceFile update(ReferenceFile referenceFile) {
		ReferenceFile file = referenceFileDao.save(referenceFile);
		return file;
	}

	@Override
	public ReferenceFile findById(Integer fileId) {
		ReferenceFile file = referenceFileDao.findOne(fileId);
		return file;
	}

	@Override
	public int deleteBatch(Integer[] refFileIds) {
		if(null == refFileIds) return -1;
		for(Integer id : refFileIds){
			referenceFileDao.delete(id);
		}
		return 0;
	}

}
