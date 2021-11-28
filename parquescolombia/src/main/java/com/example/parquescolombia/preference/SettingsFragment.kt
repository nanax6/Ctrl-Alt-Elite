package com.example.parquescolombia.preference

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.example.parquescolombia.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}