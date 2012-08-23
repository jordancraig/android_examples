package com.jieehd.android.examples;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;


public class SystemInfo extends PreferenceActivity {
	
	private Preference disk_info;
	private Preference net_info;
	private Preference sys_info;
	private Intent i;
	private Context cx;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.system_info_examples);
		
		disk_info = findPreference("disk_info");
		disk_info.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				i = new Intent(getApplicationContext(), DiskInfo.class);
				startActivity(i);
				return false;
			}
			
		});
		
		net_info = findPreference("net_info");
		net_info.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				i = new Intent(getApplicationContext(), NetInfo.class);
				startActivity(i);
				return false;
			}
			
		});
		
		sys_info = findPreference("sys_info");
		sys_info.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				i = new Intent(getApplicationContext(), SysInfo.class);
				startActivity(i);
				return false;
			}
			
		});
	}

}
