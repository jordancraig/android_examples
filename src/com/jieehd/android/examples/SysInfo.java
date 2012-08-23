package com.jieehd.android.examples;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class SysInfo extends Activity {
	
	private TextView sys_info;
	private static StringBuffer buffer;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sys_info);
		
		sys_info = (TextView) findViewById(R.id.sys_info_tv);
		sys_info.setText(getSystemProperty());
		
	}
	
	  public synchronized String run(String[] cmd, String workdirectory) throws IOException {
		  String result = "";

		  try {
		     ProcessBuilder builder = new ProcessBuilder(cmd);
		      // set working directory
		      if (workdirectory != null)
		        builder.directory(new File(workdirectory));
		      	builder.redirectErrorStream(true);
		      	Process process = builder.start();
		      	InputStream in = process.getInputStream();
		      	byte[] re = new byte[1024];
		      	while (in.read(re) != -1) {
		      		System.out.println(new String(re));
		      		result = result + new String(re);
		      	}
		      	
		      	in.close();

		   } catch (Exception ex) {
		      ex.printStackTrace();
		   }
		 return result;
	  }
	
	public static String getSystemProperty() {
		
		
		
		buffer = new StringBuffer();
		initProperty("java.vendor.url", "java.vendor.url");
		initProperty("java.class.path", "java.class.path");
		initProperty("user.home", "user.home");
		initProperty("java.class.version", "java.class.version");
		initProperty("os.version", "os.version");
		initProperty("java.vendor", "java.vendor");
		initProperty("user.dir", "user.dir");
		initProperty("user.timezone", "user.timezone");
		initProperty("path.separator", "path.separator");
		initProperty(" os.name", " os.name");
		initProperty("os.arch", "os.arch");
		initProperty("line.separator", "line.separator");
		initProperty("file.separator", "file.separator");
		initProperty("user.name", "user.name");
		initProperty("java.version", "java.version");
		initProperty("java.home", "java.home");
		
		return buffer.toString();
	}
		  
	private static String initProperty(String description, String propertyStr) {
		if (buffer == null) {
		      buffer = new StringBuffer();
		}
		buffer.append(description).append(":");
		buffer.append(System.getProperty(propertyStr)).append("\n");
		return buffer.toString();
	}

}
