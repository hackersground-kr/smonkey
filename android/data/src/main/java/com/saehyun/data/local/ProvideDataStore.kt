package com.saehyun.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

private const val DATASTORE_NAME = "SMONKEY_DATASTORE"

internal val Context.datastore: DataStore<Preferences> by preferencesDataStore(
    name = DATASTORE_NAME,
)
