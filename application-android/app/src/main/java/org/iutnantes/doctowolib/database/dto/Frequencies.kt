package org.iutnantes.doctowolib.database.dto


import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.*
import org.iutnantes.doctowolib.database.dto.interfaces.IFrequencies
import org.iutnantes.doctowolib.errors.NoScheduleProvidedError

class Frequencies private constructor(
    override val daysBetweenTakes: Int, override val minimumTimeBetweenTakes: Int, override val isNeeded : Boolean,
    override val intakeTimes : Array<LocalDateTime>, val startDate : LocalDate, val endDate : LocalDate
): IFrequencies {


    override fun noSchedule(): Boolean {
        return intakeTimes.isEmpty()
    }


    companion object {

        fun createFrequencyTime(daysBetweenTakes: Int, intakeTimes : Array<String>,
                                startDate : LocalDate, endDate : LocalDate,
                                parameters: Parameters
        ) : Frequencies {

            if(intakeTimes.isEmpty()) throw NoScheduleProvidedError("Aucun Horaire fourni pour la création")

            val result = mutableListOf<LocalDateTime>()
            val time = mutableListOf<LocalTime>()
            for (hour in intakeTimes) {
                when (hour) {
                    "Matin" -> time.add(parameters.morningTime)
                    "Midi" -> time.add(parameters.noonTime)
                    "Soir" -> time.add(parameters.eveningTime)
                    else -> time.add(LocalTime.parse(hour))
                }
            }
            var addDate = startDate
            while (addDate.daysUntil(endDate) >= 0) {

                for (time in time) {
                    val dateTimeToAdd = LocalDateTime.parse("${addDate}T${time}")
                    result.add(dateTimeToAdd)
                }
                addDate = addDate.plus(DatePeriod(days = daysBetweenTakes + 1))
            }
            return Frequencies(daysBetweenTakes,0,false,result.toTypedArray(),startDate,endDate)
        }
    }

}