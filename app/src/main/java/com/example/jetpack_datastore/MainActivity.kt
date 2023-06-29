package com.example.jetpack_datastore

import android.content.Context
import android.media.audiofx.Virtualizer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
// RxJava 形式
//val Context.dataStore2: RxDataStore<Preferences> by rxPreferencesDataStore(name = "settings")

// Proto DataStore

//val Context.settingsDataStore: DataStore<Settings> by dataStore(
//    fileName = "settings.pb",
//    serializer = SettingsSerializer
//)

val EXAMPLE_COUNTER = intPreferencesKey("example_counter")

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)






    }

    /**
     * 使用 Preferences DataStore 存储键值对
     * 读取内容
     */
    fun redCounter(): Flow<Int> = dataStore.data.map { preferences ->
        preferences[EXAMPLE_COUNTER] ?: 0
    }

    /**
     * 使用 Preferences DataStore 存储键值对
     * 写入内容
     */
    suspend fun incrementCounter() {
        dataStore.edit { settings ->
            val  currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = currentCounterValue +1
        }
    }

}