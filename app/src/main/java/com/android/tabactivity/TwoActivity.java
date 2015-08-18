package com.android.tabactivity;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class TwoActivity extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings2);
    }
}

