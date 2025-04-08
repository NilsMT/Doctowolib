package org.iutnantes.doctowolib.database.dto

import kotlinx.datetime.LocalDate
import org.iutnantes.doctowolib.database.dto.interfaces.IPrescriptions
import org.iutnantes.doctowolib.database.dto.interfaces.ITreatment

open class Prescriptions(
    override val id: Int,
    override val renewable: Boolean,
    override val startDate: LocalDate,
    override val renewalPeriod: LocalDate,
    override val treatments: Array<ITreatment>
) : IPrescriptions {





}