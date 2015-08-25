package com.android.tabactivity;

import android.content.res.Resources;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.preference.RingtonePreference;
import android.text.TextUtils;
import android.view.KeyEvent;

public class TwoActivity extends PreferenceActivity
{
    Preference Second;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initScreen();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {

            removeScreen();

            initScreen();
            //addPreferencesFromResource(R.xml.settings);
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void initScreen() {
        addPreferencesFromResource(R.xml.settings2);

        bindPreferenceSummaryToValue(findPreference("Second"));

        /*Second = (Preference) findPreference("Second");
        Second.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                removeScreen();
                addPreferencesFromResource(R.xml.settings3);
                return true;
            }
        });*/

    }

    private void removeScreen() {
        PreferenceScreen ps= getPreferenceScreen();
        ps.removeAll();
    }

    private Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            removeScreen();
            addPreferencesFromResource(R.xml.settings3);

            return true;
        }
    };


    private  void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        // Trigger the listener immediately with the preference's
        // current value.
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference,
                PreferenceManager
                        .getDefaultSharedPreferences(preference.getContext())
                        .getString(preference.getKey(), ""));
    }
}

