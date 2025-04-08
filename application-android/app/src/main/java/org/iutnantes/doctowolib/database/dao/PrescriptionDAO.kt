package org.iutnantes.doctowolib.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import org.iutnantes.doctowolib.database.entity.PrescriptionWithMedications
import org.iutnantes.doctowolib.database.entity.PrescriptionEntity
import org.iutnantes.doctowolib.database.entity.MedicationEntity


@Dao
abstract class PrescriptionDAO {

    fun insertPrescriptionWithTreatments(prescriptionEntity: PrescriptionEntity, treatments: List<MedicationEntity>) {
        this.insertTreatments(treatments)
        this.insertPrescription(prescriptionEntity)
    }

    @Insert
    protected abstract fun insertPrescription(prescriptionEntity: PrescriptionEntity)

    @Insert
    abstract fun insertTreatments(treatments: List<MedicationEntity>)

    @Insert
    abstract fun insertOneTreatment(treatmentEntity: MedicationEntity)

    @Transaction
    @Query("SELECT * FROM Prescriptions")
    abstract fun getPrescriptionWithTreatments() : List<PrescriptionWithMedications>
}