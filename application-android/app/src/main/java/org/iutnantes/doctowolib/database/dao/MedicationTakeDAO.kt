package org.iutnantes.doctowolib.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import org.iutnantes.doctowolib.controller.data.ReccurentMedicationTake

@Dao
abstract class MedicationTakeDAO {

    @Insert
    abstract fun insertMedicationTake(recurrentMedicationTake: ReccurentMedicationTake)

    @Transaction
    @Query("SELECT * FROM ReccurentMedicationTake")
    abstract fun getMedicationTake() : ReccurentMedicationTake

    @Update
    abstract fun updateMedicationTake(recurrentMedicationTake: ReccurentMedicationTake)
}