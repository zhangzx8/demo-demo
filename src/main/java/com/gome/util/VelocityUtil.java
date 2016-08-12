package com.gome.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class VelocityUtil {

	/**
	 * 
	 * @param map      data
	 * @param path     classPath路径
	 * @return
	 */
	public static String getContent(Map<String, Object> map, String path) {
		StringWriter sw = null;
		BufferedWriter bw = null;
		try {
			Properties p = new Properties();
			p.setProperty("file.resource.loader.class",
					"org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
			p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
			p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
			Velocity.init(p);
			VelocityContext context = new VelocityContext();
			context.put("map", map);
			Template template = Velocity.getTemplate(path,"UTF-8");
			sw = new StringWriter();
			bw = new BufferedWriter(sw);
			template.merge(context, bw);
			bw.flush();
			StringBuffer sb = sw.getBuffer();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return "";
	}
	
	
	/**
	 * String parentPath  = request.getSession().getServletContext().getRealPath("");
	 * String path2 = "\\template\\hello2.vm";
	 * @param map    data
	 * @param path   绝对路径
	 * @return
	 */
	public static String getContent2(Map<String, Object> map, String parentPath, String path) {
		System.out.println("parentPath:"+parentPath+"|path:"+path);
		StringWriter sw = null;
		BufferedWriter bw = null;
		try {
			Properties p = new Properties();
			p.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, parentPath);
			p.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
			p.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
			Velocity.init(p);
			VelocityContext context = new VelocityContext();
			context.put("map", map);
			Template template = Velocity.getTemplate(path,"UTF-8");
			sw = new StringWriter();
			bw = new BufferedWriter(sw);
			template.merge(context, bw);
			bw.flush();
			StringBuffer sb = sw.getBuffer();
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sw != null) {
				try {
					sw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return "";
	}
	

}
