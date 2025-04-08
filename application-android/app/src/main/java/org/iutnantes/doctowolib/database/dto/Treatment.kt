package org.iutnantes.doctowolib.database.dto

import kotlinx.datetime.LocalDate
import org.iutnantes.doctowolib.database.dto.interfaces.IFrequencies
import org.iutnantes.doctowolib.database.dto.interfaces.ITreatment

class Treatment(override val frequency: IFrequencies,
                override val dosage: Pair<Int, String>,
                override val endDate: LocalDate,
                override val medication: IMedication): ITreatment {




    companion object {

        fun createTreatment(medicationName : String, frequencies: Frequencies,
                            dosage: Int, unit : String) : Treatment {



            return TODO("Pas encore implémenter")
        }

    }

}