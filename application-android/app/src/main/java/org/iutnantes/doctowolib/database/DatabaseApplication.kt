package org.iutnantes.doctowolib.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.iutnantes.doctowolib.controller.data.ReccurentMedicationTake
import org.iutnantes.doctowolib.controller.data.TreeMapTimeConverter
import org.iutnantes.doctowolib.database.dao.PrescriptionDAO
import org.iutnantes.doctowolib.database.dao.MedicationTakeDAO
import org.iutnantes.doctowolib.database.entity.DateArrayConverter
import org.iutnantes.doctowolib.database.entity.DateConverter
import org.iutnantes.doctowolib.database.entity.FrequenciesEntity
import org.iutnantes.doctowolib.database.entity.PrescriptionEntity
import org.iutnantes.doctowolib.database.entity.PairConverter
import org.iutnantes.doctowolib.database.entity.MedicationEntity

@Database(entities = [FrequenciesEntity::class,
    PrescriptionEntity::class,
    MedicationEntity::class, ReccurentMedicationTake::class], version = 1, exportSchema = true)
@TypeConverters(*[DateConverter::class, DateArrayConverter::class, PairConverter::class, TreeMapTimeConverter::class])
abstract class DatabaseApplication: RoomDatabase() {

    abstract fun prescriptionDAO() : PrescriptionDAO

    abstract fun medicationTakeDAO() : MedicationTakeDAO



    companion object {

        private lateinit var dataBaseInstance : DatabaseApplication

        fun getOrCreate(context : Context) : DatabaseApplication {
            if (!this::dataBaseInstance.isInitialized) {
                dataBaseInstance = Room.databaseBuilder(context,DatabaseApplication::class.java,"data").build()
            }
            return dataBaseInstance

        }

    }
}