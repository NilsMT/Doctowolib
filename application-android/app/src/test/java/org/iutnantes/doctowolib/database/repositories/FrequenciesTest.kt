package org.iutnantes.doctowolib.database.repositories

import kotlinx.datetime.DateTimeUnit
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.datetime.plus
import org.iutnantes.doctowolib.database.dto.Frequencies
import org.iutnantes.doctowolib.database.dto.Parameters
import org.iutnantes.doctowolib.errors.NoScheduleProvidedError
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class FrequenciesTest {
    private val param = Parameters(LocalTime(8,0), LocalTime(12,0), LocalTime(20,0))
    @Test
    fun testThrowing() {

        assertThrows<NoScheduleProvidedError> {
            Frequencies.createFrequencyTime(0, emptyArray(),
            LocalDate(2025,1,1),LocalDate(2025,1,1),param)}
    }


    lateinit var frequencies : Frequencies
    @ParameterizedTest(name= "Test avec {0}")
    @MethodSource("simpleTimes")
    fun testSimpleFrequency(schedule : Array<String>) {
        val uniqueDate = LocalDate(2025,1,1)

        assertDoesNotThrow {frequencies = Frequencies.createFrequencyTime(0,schedule,uniqueDate,uniqueDate,param)}

        for (i in schedule.indices) {
            when (schedule[i]) {
                "Matin" -> assertTrue(frequencies.intakeTimes[i].time == param.morningTime)
                "Midi" -> assertTrue(frequencies.intakeTimes[i].time == param.noonTime)
                "Soir" -> assertTrue(frequencies.intakeTimes[i].time == param.eveningTime)
            }
        }

    }

    @ParameterizedTest(name= " Test avec comme horraire {0} et range de jours = {1}")
    @MethodSource("dateSource")
    fun testScheduleAndDays(schedule: Array<String>, intakeDaysQuantity : Int, quantityBetweenDays : Int) {
        val startDate = LocalDate(2025,1,1)
        val endDate = startDate.plus(intakeDaysQuantity,DateTimeUnit.DAY)

        assertDoesNotThrow {frequencies = Frequencies.createFrequencyTime(quantityBetweenDays
            ,schedule,startDate,endDate,param)}
        var day = 0
        for (i in frequencies.intakeTimes.indices) {

            if (day == 0 ) {
                when (schedule[i%schedule.size]) {
                    "Matin" -> assertAll({ assertTrue(frequencies.intakeTimes[i].time == param.morningTime) },
                        {
                            assertTrue(
                                frequencies.intakeTimes[i].date == startDate
                            )
                        }
                    )

                    "Midi" -> assertAll({ assertTrue(frequencies.intakeTimes[i].time == param.noonTime) },
                        {
                            assertTrue(
                                frequencies.intakeTimes[i].date == startDate
                            )
                        }
                    )
                    "Soir" -> assertAll({ assertTrue(frequencies.intakeTimes[i].time == param.eveningTime) },
                        {
                            assertTrue(
                                frequencies.intakeTimes[i].date == startDate
                            )
                        }
                    )
                }
            }else {
                when (schedule[i%schedule.size]) {
                    "Matin" -> assertAll({ assertTrue(frequencies.intakeTimes[i].time == param.morningTime) },
                        {
                            assertTrue(
                                frequencies.intakeTimes[i].date == startDate.plus(
                                    day,
                                    DateTimeUnit.DAY
                                ),
                                "$day, ${frequencies.intakeTimes[i]}"
                            )
                        }
                    )

                    "Midi" -> assertAll({ assertTrue(frequencies.intakeTimes[i].time == param.noonTime) },
                        {
                            assertTrue(
                                frequencies.intakeTimes[i].date == startDate.plus(
                                    day ,
                                    DateTimeUnit.DAY
                                )
                            )
                        }
                    )
                    "Soir" ->assertAll({ assertTrue(frequencies.intakeTimes[i].time == param.eveningTime) },
                        {
                            assertTrue(
                                frequencies.intakeTimes[i].date == startDate.plus(
                                    day,
                                    DateTimeUnit.DAY
                                )
                            )
                        }
                    )
                }
            }
            if ((i+1)%schedule.size == 0) {
                day += 1 + quantityBetweenDays
            }
        }

    }

    companion object {

        @JvmStatic
        fun simpleTimes() : Stream<Arguments> {
            return Stream.of(
                Arguments.of(arrayOf("Matin","Midi","Soir")),
                Arguments.of(arrayOf("Matin","Midi")),
                Arguments.of(arrayOf("Matin","Soir")),
                Arguments.of(arrayOf("Midi","Soir")),
                Arguments.of(arrayOf("Matin")),
                Arguments.of(arrayOf("Midi")),
                Arguments.of(arrayOf("Soir")),
            )
        }

        @JvmStatic
        fun dateSource() : Stream<Arguments> {
            val dateRange = arrayOf(Pair("1","0"),
                Pair("10","0"),
                Pair("28","0"),
                Pair("30","1"),
                Pair("30","2"),
                Pair("60","3"))
            val schedule = arrayOf(arrayOf("Matin","Midi","Soir"),
                arrayOf("Matin","Midi"),
                arrayOf("Matin","Soir"),
                arrayOf("Midi","Soir"),
                arrayOf("Matin"),
                arrayOf("Midi"),
                arrayOf("Soir"))
            val map = schedule.map { arr -> dateRange.map { dater -> Arguments.of(arr,dater.first,dater.second)} }



            return map.flatten().stream()
        }



    }

}

