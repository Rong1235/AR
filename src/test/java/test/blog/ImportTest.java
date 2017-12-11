package test.blog;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import org.easy.excel.ExcelContext;
import org.easy.excel.parsing.ExcelError;
import org.easy.excel.result.ExcelImportResult;

import sw.entity.Asset;
import test.model.BookModel;
import test.model.StudentModel;

public class ImportTest {
	public static void main(String[] args) throws Exception {
		//准备excel文件流
		InputStream excelStream = new FileInputStream("../sw/src/main/resources/upload/资产列表.xlsx");
		//创建excel上下文实例,它的构成需要配置文件的路径
		ExcelContext context = new ExcelContext("../sw/src/main/resources/excelConfig/Asset.xml");
		//按照xml配置中id为student的配置形式读取excel文件,并转换成StudentModel
		//这里的第二个参数是值,标题是第几行开始,之前也说了标题之前的数据并不是规则的数据
		//ExcelImportResult result = context.readExcel("HardwareAssets", 0,excelStream);
		ExcelImportResult result = context.readExcel("HardwareAssets", 0, excelStream,true);
		//打印导入结果,查看标题之前不规则的数据
		List<List<Object>> header = result.getHeader();
//		System.out.println(header.get(0));
//		System.out.println(header.get(1));
		//查看学生集合导入结果
		List<Asset> assets = result.getListBean();
		for(Asset ass:assets){
			System.out.println(ass);
		}		
		if(result.hasErrors()){
			System.out.println("导入包含错误，下面是错误信息：");
			for (ExcelError err:result.getErrors()) {
				System.out.println(err.getErrorMsg());
			}
		}
	}
}
