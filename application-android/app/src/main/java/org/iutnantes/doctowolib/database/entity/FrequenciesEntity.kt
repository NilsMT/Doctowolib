package org.iutnantes.doctowolib.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Entity
data class FrequenciesEntity(

    val daysBetweenTakes: Int,
    val minimumTimeBetweenTakes: Int,
    val isNeeded : Boolean,
    val intakeTimes : Array<LocalDateTime>,
    val startDate : LocalDate,
    val endDate : LocalDate
){
    @PrimaryKey var frequencyId : Int? = null
}


class DateArrayConverter {

  @TypeConverter
  fun arrayLocalDateTimeToString(input : Array<LocalDateTime>) : String {
   return Json.encodeToString(input)
  }

 @TypeConverter
 fun stringToLocalDateTimeArray(input : String): Array<LocalDateTime> {
  return Json.decodeFromString(input)
 }

}

class DateConverter {
 @TypeConverter
 fun arrayLocalDateTimeToString(input : LocalDate) : String {
  return Json.encodeToString(input)
 }

 @TypeConverter
 fun stringToLocalDateTimeArray(input : String): LocalDate {
  return Json.decodeFromString(input)
 }
}