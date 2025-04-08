package org.iutnantes.doctowolib.database.dto.interfaces

import kotlinx.datetime.LocalDateTime

interface IFrequencies {

    val daysBetweenTakes : Int
    val minimumTimeBetweenTakes : Int?
    val intakeTimes : Array<LocalDateTime>?
    val isNeeded : Boolean

    fun noSchedule() : Boolean

}