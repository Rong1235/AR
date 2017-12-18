package sw.controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
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
	
	private final ResourceLoader resourceLoader;
	
	@Value("${web.upload-path}")
	public String ROOT;

	@Autowired
	public AssetController(ResourceLoader resourceLoader) {
		this.resourceLoader = resourceLoader;
	}

//	@RequestMapping(value = "/importExcel1")
//	@ResponseBody
//	public String importExcel(@PathVariable MultipartFile file,Integer projectId,HttpServletRequest request){
//		if (file.isEmpty()) {
//			return "文件为空";
//		}
//		String fileName = file.getOriginalFilename();// 获取文件名
//		String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取文件的后缀名
//		String filePath = "classpath:/";// 文件上传后的路径
//	    fileName = UUID.randomUUID() + suffixName;
//		File dest = new File(filePath + fileName);
//		// 检测是否存在目录
//		if (!dest.getParentFile().exists()) {
//			dest.getParentFile().mkdirs();
//		}
//		try {
//			file.transferTo(dest);
//			assetService.importExcel(filePath, projectId);
//			return "上传成功";
//		} catch (Exception e){
//			e.printStackTrace();
//			return "上传失败";
//		}
//	}
	

	@RequestMapping(value = "/importExcel")
	@ResponseBody
	public String importExcel1(@PathVariable MultipartFile file,Integer projectId,HttpServletRequest request) {
		if (!file.isEmpty()) {
			String fileName = file.getOriginalFilename();// 获取文件名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));//获取文件的后缀名
		    fileName = UUID.randomUUID() + suffixName;
			try {
				Files.copy(file.getInputStream(),Paths.get(ROOT, fileName));//getOriginalFilename得到上传时的文件名
				
				String str = Paths.get(ROOT, fileName).toString();
				assetService.importExcel(str, projectId);
			} catch (Exception e) {
				e.printStackTrace();
				return "上传失败";
			}
			return "上传成功";
		}
		return "文件为空";
	}
}
