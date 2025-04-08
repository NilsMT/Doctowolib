package org.iutnantes.doctowolib.controller.data.interfaces

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime

interface ITakeMedication {

    val startDate : LocalDate
    val endDate : LocalDate

    val prescriptionId : Int

    fun LastIntake() : LocalDateTime


}