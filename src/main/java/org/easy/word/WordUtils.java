package org.easy.word;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Map;

import sun.misc.BASE64Encoder;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class WordUtils {
	private Configuration configuration = null;

	public WordUtils() {
		configuration = new Configuration();
		configuration.setDefaultEncoding("utf-8");
	}
	public void createDoc(Map<String, Object> dataMap, String fileName)
			throws UnsupportedEncodingException {
		configuration.setClassForTemplateLoading(this.getClass(), "/model");
		Template t = null;
		try {
			// test.ftl为要装载的模板
			t = configuration.getTemplate("test.ftl");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 输出文档路径及名称
		File outFile = new File(fileName);
		Writer out = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(outFile);
			OutputStreamWriter oWriter = new OutputStreamWriter(fos, "UTF-8");
			out = new BufferedWriter(oWriter);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			t.process(dataMap, out);
			out.close();
			fos.close();
		} catch (TemplateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	//获得图片的base64码
	 @SuppressWarnings("deprecation")
	public String getImageBase(String src) {
		if (src == null || src == "") {
			return "";
		}
		File file = new File(src);
		if (!file.exists()) {
			return "";
		}
		InputStream in = null;
		byte[] data = null;
		try {
			in = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}
}
