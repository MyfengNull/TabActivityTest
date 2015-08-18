package com.android.tabactivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class OneActivity extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }
}

