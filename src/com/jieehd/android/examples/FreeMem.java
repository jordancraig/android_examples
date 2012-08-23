package com.jieehd.android.examples;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.widget.TextView;

public class FreeMem extends Activity {
	
	private TextView free_mem;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.free_mem);
		
		free_mem = (TextView) findViewById(R.id.free_mem_tv);
		free_mem.setText(getAvailableInternalMemorySize());
		
	}
	
    /**
     * Calculates the free memory of the device. This is based on an inspection of the filesystem, which in android
     * devices is stored in RAM.
     *
     * @return Number of bytes available.
     */
    public static String getAvailableInternalMemorySize() {
        final File path = Environment.getDataDirectory();
        final StatFs stat = new StatFs(path.getPath());
        final long blockSize = stat.getBlockSize();
        final long availableBlocks = stat.getAvailableBlocks();
        String result = String.valueOf((availableBlocks * blockSize)/1024/1024);
        return "Free memory: " + result + "MB";
    }
}
