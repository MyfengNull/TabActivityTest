package com.android.tabactivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by scorpio92 on 19.08.15.
 */
public class InsideActivity extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_inside);
    }
}