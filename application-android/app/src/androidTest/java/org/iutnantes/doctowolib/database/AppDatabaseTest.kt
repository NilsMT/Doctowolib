package org.iutnantes.doctowolib.database

import android.util.Log
import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.datetime.LocalDate
import org.iutnantes.doctowolib.database.dao.PrescriptionDAO
import org.iutnantes.doctowolib.database.entity.PrescriptionWithMedications
import org.iutnantes.doctowolib.database.entity.PrescriptionEntity
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class AppDatabaseTest {

    private lateinit var prescriptionDAO: PrescriptionDAO
    private lateinit var database: DatabaseApplication

    @BeforeEach
    fun creationDb() {
        val context = InstrumentationRegistry.getInstrumentation().context
        database = Room.inMemoryDatabaseBuilder(context,DatabaseApplication::class.java).build()
        prescriptionDAO = database.prescriptionDAO()
    }


    @Test
    fun testInsertionSimplePrescription() {

        val prescriptionEntity = PrescriptionEntity(
            1,
            false,
            LocalDate(2025,1,1),
            LocalDate(2025,1,5)
        )
        /*val Presc = PrescriptionEntity(
            1,
            1,
            Pair(1,"mg"),
            LocalDate(2025,1,5),

        )

        assertDoesNotThrow {
            ordonanceDao.insertOrdonanceAvecPrescriptions(Ordo, listOf(Presc))
        }*/
        lateinit var prescription : PrescriptionWithMedications

        assertDoesNotThrow { prescription = prescriptionDAO.getPrescriptionWithTreatments().first()}

        Log.d("Debug", mapOf(Pair(prescription.prescriptionEntity,prescription.medications)).toString())

    }


}