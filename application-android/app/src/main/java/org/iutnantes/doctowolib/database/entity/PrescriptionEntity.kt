package org.iutnantes.doctowolib.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.datetime.LocalDate


@Entity(tableName = "Prescriptions")
data class PrescriptionEntity (
    @PrimaryKey val id: Int,
    val renewable: Boolean,
    val startDate: LocalDate,
    val renewalPeriod: LocalDate,
)


