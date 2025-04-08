package org.iutnantes.doctowolib.controller.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.iutnantes.doctowolib.database.entity.PrescriptionEntity
import org.iutnantes.doctowolib.database.entity.MedicationEntity
import java.util.TreeMap



@Entity(foreignKeys = [ForeignKey(PrescriptionEntity::class, ["id"],["id"])])
data class ReccurentMedicationTake(

    val medicationStartDate: LocalDate,
    val medicationEndDate: LocalDate,
    val reccurentPrescriptionId : Int,
    @Embedded val prescription : MedicationEntity,
    val intakeTime : TreeMap<LocalDateTime,LocalDateTime?> = TreeMap()

    ) {
    @PrimaryKey(true) var id : Int? = null

    fun lastIntake(): LocalDateTime {
        
        return intakeTime.lowerEntry(Clock.System.now().toLocalDateTime(TimeZone.of("Europe/Paris")))?.value ?: throw NoSuchElementException()

    }

    companion object {

        fun createTakeWithTimeMap(startDate: LocalDate,
                                  endDate: LocalDate,
                                  prescriptionId : Int,
                                  prescription : MedicationEntity,) : ReccurentMedicationTake {

            val takeTime: TreeMap<LocalDateTime,LocalDateTime?> = TreeMap()
            for (time in prescription.frequencies.intakeTimes) {
                takeTime[time] = null
            }
            return ReccurentMedicationTake(startDate,endDate,prescriptionId,prescription,takeTime)
        }
    }
}


class TreeMapTimeConverter {

    @TypeConverter
    fun treemapToJson(tree : TreeMap<LocalDateTime,LocalDateTime?>) : String {
        return Json.encodeToString(tree)
    }

    @TypeConverter
    fun jsonToTreemap(json : String) : TreeMap<LocalDateTime,LocalDateTime?> {
        return Json.decodeFromString<TreeMap<LocalDateTime,LocalDateTime?>>(json)
    }
}