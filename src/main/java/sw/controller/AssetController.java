package sw.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import sw.service.IAssetService;

@Controller
@RequestMapping("/ass")
public class AssetController {
	@Autowired
	private IAssetService assetService;

	@RequestMapping(value = "/importExcel")
	@ResponseBody
	public String importExcel(@PathVariable MultipartFile file,Integer projectId){
		if (file.isEmpty()) {
			return "文件为空";
		}
		String fileName = file.getOriginalFilename();// 获取文件名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取文件的后缀名
		String filePath = "E://";// 文件上传后的路径
	    fileName = UUID.randomUUID() + suffixName;
		File dest = new File(filePath + fileName);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			assetService.importExcel(filePath, projectId);
			return "上传成功";
		} catch (Exception e){
			return "上传失败";
		}
	}
}
