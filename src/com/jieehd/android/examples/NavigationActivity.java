package com.jieehd.android.examples;

import security.SecurityNav;
import snake.game.Snake;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import android.view.Menu;

public class NavigationActivity extends PreferenceActivity {
	
	private Preference sys_info;
	private Preference mem_info;
	private Preference snake;
	private Preference security;
	private Intent i;
	private PreferenceCategory nav_tree;

    @SuppressWarnings("deprecation")
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.navigation_examples);
        sys_info = findPreference("sys_info");
        mem_info = findPreference("mem_info");
        snake = findPreference("snake_game");
        security = findPreference("security");
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_navigation, menu);
        return true;
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen prefScreen, Preference pref) {
    	if (pref == sys_info) {
    		i = new Intent(this, SysInfo.class);
    		startActivity(i);
    	} else if (pref == mem_info) {
    		i = new Intent(this, MemNav.class);
    		startActivity(i);
    	} else if (pref == snake) {
    		i = new Intent(this, Snake.class);
    		startActivity(i);
    	} else if (pref == security) {
    		i = new Intent(this, SecurityNav.class);
    		startActivity(i);
    	}
    return true;
    }
}
