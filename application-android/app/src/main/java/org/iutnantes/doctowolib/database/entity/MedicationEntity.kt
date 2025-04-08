package org.iutnantes.doctowolib.database.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


@Entity
data class MedicationEntity(
    var medicationId: Int,
    val medicationName : String,
    val dosage: Pair<Int, String>,
    @Embedded val frequencies : FrequenciesEntity,

    ) {
    @PrimaryKey(true) var prescriptionId: Int? = null
}



class PairConverter {


    @TypeConverter
    fun pairToString(pair: Pair<Int,String>) :String {
        return Json.encodeToString<Pair<Int,String>>(pair)
    }

    @TypeConverter
    fun stringToPair(string: String) : Pair<Int,String> {
        return Json.decodeFromString<Pair<Int,String>>(string)
    }
}