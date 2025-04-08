package org.iutnantes.doctowolib.database.dto.interfaces

import kotlinx.datetime.LocalDate
import org.iutnantes.doctowolib.database.dto.IMedication

interface ITreatment {

    val frequency : IFrequencies
    val dosage : Pair<Int, String>
    val endDate : LocalDate
    val medication : IMedication

}