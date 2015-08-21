package com.android.tabactivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

public class OneActivity extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        Resources res = getResources();

        IconPreferenceScreen notify = (IconPreferenceScreen) findPreference("Notifications");
        IconPreferenceScreen app = (IconPreferenceScreen) findPreference("Application");

        Drawable notifyIcon = res.getDrawable(R.drawable.ic_setting_notify);
        Drawable appIcon = res.getDrawable(R.drawable.ic_setting_app);

        notify.setIcon(notifyIcon);
        app.setIcon(appIcon);


        notify.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(OneActivity.this, PreferencesActivity2.class));
                return true;
            }
        });
        app.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(OneActivity.this, PreferencesActivity3.class));
                return true;
            }
        });
    }
}

