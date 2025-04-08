package org.iutnantes.doctowolib.database.entity

import androidx.room.Embedded
import androidx.room.Relation


data class PrescriptionWithMedications(
    @Embedded
    val prescriptionEntity: PrescriptionEntity,
    @Relation(parentColumn = "id", entityColumn = "medicationId")
    val medications : List<MedicationEntity>

)