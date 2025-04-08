package org.iutnantes.doctowolib.controller.data

import android.content.Context
import kotlinx.datetime.LocalDate
import org.iutnantes.doctowolib.database.DatabaseApplication
import org.iutnantes.doctowolib.database.dto.Frequencies
import org.iutnantes.doctowolib.database.dto.Parameters
import org.iutnantes.doctowolib.database.entity.FrequenciesEntity
import org.iutnantes.doctowolib.database.entity.MedicationEntity

class MedicationCreationManager() {


    companion object {

        suspend fun createPrescriptionAndMedication(
            appContext: Context,
            daysBetweenIntakes: Int,
            intakeTimes: Array<String>,
            startDate: LocalDate,
            endDate: LocalDate,
            unit: String,
            dosage: Int,
            medicationName: String,
            prescriptionId: Int
        ): Pair<ReccurentMedicationTake,MedicationEntity> {

            val database = DatabaseApplication.getOrCreate(appContext)
            val takeDAO = database.medicationTakeDAO()
            val prescriptionDAO = database.prescriptionDAO()

            val parameters = Parameters.getParameters(appContext)

            val frequencies = Frequencies.createFrequencyTime(
                daysBetweenIntakes, intakeTimes, startDate, endDate, parameters)

            val frequencyEntity = FrequenciesEntity(daysBetweenIntakes, 0,false,frequencies.intakeTimes,startDate,endDate)

            val medicationEntity = MedicationEntity(prescriptionId,medicationName,Pair(dosage,unit),frequencyEntity)

            val medicationTake = ReccurentMedicationTake.createTakeWithTimeMap(startDate,endDate, prescriptionId,medicationEntity)

            takeDAO.insertMedicationTake(medicationTake)
            prescriptionDAO.insertOneTreatment(medicationEntity)

            return Pair(medicationTake,medicationEntity)

        }


    }





}