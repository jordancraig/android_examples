package com.jieehd.android.examples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.view.Menu;

public class NavigationActivity extends PreferenceActivity {
	
	private Preference sys_info;
	private Intent i;
	private Context cx;

    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.navigation_examples);
        
        sys_info = findPreference("sys_info");
        sys_info.setOnPreferenceClickListener(new OnPreferenceClickListener() {

			@Override
			public boolean onPreferenceClick(Preference preference) {
				// TODO Auto-generated method stub
				i = new Intent(getApplicationContext(), SystemInfo.class);
				startActivity(i);
				return false;
			}
        	
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_navigation, menu);
        return true;
    }

    
}
