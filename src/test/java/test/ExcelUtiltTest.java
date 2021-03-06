package test;

import java.util.List;

import org.easy.excel.util.ExcelUtil;
import org.springframework.core.io.ClassPathResource;

/**
 * ExcelUtil 测试类
 * @author lisuo
 *
 */
public class ExcelUtiltTest {
	public static void main(String[] args) throws Exception {
		
		ClassPathResource resource = new ClassPathResource("/upload/资产列表.xlsx");
		List<List<Object>> list = ExcelUtil.readExcel(resource.getInputStream(), 0);
		for (int i = 0; i < list.size(); i++) {
			// 获取每一行
			System.out.println("第" + (i + 1) + " 行的数据如下");
			List<Object> rows = list.get(i);
			// 便利每一行中的元素
			for (int j = 0; j < rows.size(); j++) {
				Object cellValue = rows.get(j);
				System.out.print("第【" + (i + 1) + "】行第【" + (j + 1) + "】列的值是" + "【" + cellValue + "】");
				System.out.print("    ");
			}
			System.out.println();
		}
		resource.getInputStream().close();
	}
}
