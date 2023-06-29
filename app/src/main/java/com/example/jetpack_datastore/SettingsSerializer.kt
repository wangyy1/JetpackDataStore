package com.example.jetpack_datastore

import androidx.datastore.core.Serializer
import java.io.InputStream

//object SettingsSerializer : Serializer<Settings> {
//    override val defaultValue: Settings = Settings.getDefaultInstance()
//
//    override suspend fun readFrom(input: InputStream): Settings {
//        try {
//            return Settings.parseFrom(input)
//        } catch (exception: InvalidProtocolBufferException) {
//            throw CorruptionException("Cannot read proto.", exception)
//        }
//    }
//
//    override suspend fun writeTo(
//        t: Settings,
//        output: OutputStream) = t.writeTo(output)
//}
