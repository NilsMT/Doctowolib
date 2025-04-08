package org.iutnantes.doctowolib.database.dto.interfaces

import kotlinx.datetime.LocalTime

interface IParameters {

    val morningTime : LocalTime
    val noonTime : LocalTime
    val eveningTime : LocalTime


}