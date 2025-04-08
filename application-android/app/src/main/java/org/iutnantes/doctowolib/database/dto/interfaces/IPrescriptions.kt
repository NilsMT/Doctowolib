package org.iutnantes.doctowolib.database.dto.interfaces

import kotlinx.datetime.LocalDate

/**
 *  Ordonances Interface
 *
 *  Utilise [IUser]
 *
 *  Contient un array de [ITreatment]
 *
 *  @property renewable Indique si l'ordonance est ***encore*** renouvelable
 *  @property treatments Liste des médicament préscrits dans l'ordonances
 *
 */
interface IPrescriptions {

    val id : Int
    val renewable : Boolean
    val startDate : LocalDate
    val renewalPeriod : LocalDate
    val treatments : Array<ITreatment>
    

}