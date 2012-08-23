package com.jieehd.android.examples;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;

public class MemNav extends PreferenceActivity {
	
	private Preference free_mem;
	private Intent i;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.mem_nav);
		
        free_mem = findPreference("free_mem");
        free_mem.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				i = new Intent(getApplicationContext(), FreeMem.class);
				startActivity(i);
				return false;
			}
        	
        });
	}

}
