package com.jieehd.android.examples;


	
	import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

	public class DiskInfo extends Activity {
		
		private TextView displayInfo;
		
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.disk_info);
			
			displayInfo = (TextView) findViewById(R.id.disk_info_tv);
			displayInfo.setText(fetch_disk_info());
			
		}
	

		  public synchronized String run(String[] cmd, String workdirectory)
		      throws IOException {
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
	
		

		  public static String fetch_disk_info() {
		    String result = null;
		    DiskInfo cmdexe = new DiskInfo();
		    try {
		      String[] args = { "/system/bin/df" };
		      result = cmdexe.run(args, "/system/bin/");
		    } catch (IOException ex) {
		      ex.printStackTrace();
		    }
		    return result;
		 }
	
	}
	
