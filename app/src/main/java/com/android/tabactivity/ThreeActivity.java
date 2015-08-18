package com.android.tabactivity;

/**
 * Created by scorpio92 on 18.08.15.
 */
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class ThreeActivity extends PreferenceActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings3);
    }
}
