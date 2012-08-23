package com.jieehd.android.examples;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class NetInfo extends Activity {
	
	private TextView net_info_tv;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.net_info);
		
		net_info_tv = (TextView) findViewById(R.id.net_info_tv);
		net_info_tv.setText(fetch_netstat_info());
		net_info_tv.setMovementMethod(new ScrollingMovementMethod());
		
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
	
	
	  public static String fetch_netstat_info() {
	    String result = null;
	    NetInfo netinfo = new NetInfo();
	    try {
	      String[] args = { "/system/bin/netstat" };
	      result = netinfo.run(args, "/system/bin/");
	    } catch (IOException ex) {
	      ex.printStackTrace();
	    }
	    return result;
	  }

}
