package org.iutnantes.doctowolib.database.dto

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

import kotlinx.datetime.LocalTime
import kotlinx.serialization.Serializable
import org.iutnantes.doctowolib.database.dto.interfaces.IParameters

val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name="Parametres")

@Serializable
data class Parameters(
    override val morningTime: LocalTime,
    override val noonTime: LocalTime,
    override val eveningTime: LocalTime
) : IParameters {

    companion object {
        private val morningTimeKey = stringPreferencesKey("heureMatin")
        private val noonTimeKey = stringPreferencesKey("heuremMidi")
        private val eveningTimeKey = stringPreferencesKey("heureSoir")
        suspend fun getParameters (context : Context) : Parameters {
            lateinit var noonTime: LocalTime
            lateinit var morningTime : LocalTime
            lateinit var eveningTime : LocalTime


            val morningTimeFlux  = context.dataStore.data.map { pref -> pref[morningTimeKey]  }
            morningTime = LocalTime.parse(morningTimeFlux.first()!!)

            val noonTimeFlux  = context.dataStore.data.map { pref -> pref[noonTimeKey]  }
            noonTime = LocalTime.parse(noonTimeFlux.first()!!)

            val eveningTimeFlux  = context.dataStore.data.map { pref -> pref[eveningTimeKey]  }
            eveningTime = LocalTime.parse(eveningTimeFlux.first()!!)
            return Parameters(morningTime,noonTime,eveningTime)
        }

        suspend fun saveParameters (parameters: Parameters, context: Context) {

            context.dataStore.edit { param ->
                param[morningTimeKey] = parameters.morningTime.toString()
                param[noonTimeKey] = parameters.noonTime.toString()
                param[eveningTimeKey] = parameters.eveningTime.toString()
            }

        }
    }

}
