package com.android.tabactivity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class OneActivity extends PreferenceActivity
{

    public static final String ACTION_SECOND_ACTIVITY = "com.android.tabactivity.PreferencesActivity2";

    IconPreferenceScreen First;
    Drawable FirstIcon;

    IconPreferenceScreen Second;
    Drawable SecondIcon;

    Resources res;

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

            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    private void initScreen() {
        addPreferencesFromResource(R.xml.settings);

        res = getResources();

        First = (IconPreferenceScreen) findPreference("First");
        //IconPreferenceScreen app = (IconPreferenceScreen) findPreference("Application");

        FirstIcon = res.getDrawable(R.drawable.ic_setting_notify);
        //Drawable appIcon = res.getDrawable(R.drawable.ic_setting_app);

        First.setIcon(FirstIcon);
        //app.setIcon(appIcon);


        First.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                removeScreen();
                addPreferencesFromResource(R.xml.settings2);

                Second = (IconPreferenceScreen) findPreference("Second");
                //IconPreferenceScreen app = (IconPreferenceScreen) findPreference("Application");

                SecondIcon = res.getDrawable(R.drawable.ic_setting_notify);
                //Drawable appIcon = res.getDrawable(R.drawable.ic_setting_app);

                Second.setIcon(SecondIcon);
                //app.setIcon(appIcon);


                Second.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                    @Override
                    public boolean onPreferenceClick(Preference preference) {
                        removeScreen();
                        addPreferencesFromResource(R.xml.settings3);
                        return true;
                    }
                });

                return true;
            }
        });

        /*Preference Second = (Preference) findPreference("Second");
        Second.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                removeScreen();
                addPreferencesFromResource(R.xml.settings3);
                return true;
            }
        });*/
        //bindPreferenceSummaryToValue(findPreference("Second"));
        /*Preference myPref = (Preference) findPreference("myKey");
        myPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
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

