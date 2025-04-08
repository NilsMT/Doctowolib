package org.iutnantes.doctowolib.database.dto

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.LocalTime
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class ParametersTest {

    private lateinit var context : Context
    @Test
    fun testSaveParameters() {
        val hour = LocalTime(1, 0, 0)
        val parameters = Parameters(hour, hour, hour)
        context = InstrumentationRegistry.getInstrumentation().targetContext
        assertDoesNotThrow {
            runBlocking { Parameters.saveParameters(parameters, context) }
        }

    }

    @Test
    fun testSaveLoadParameters()= runTest {
        val hour = LocalTime(1, 0, 0)
        val parameters = Parameters(hour, hour, hour)
        context = InstrumentationRegistry.getInstrumentation().targetContext
        Parameters.saveParameters(parameters, context)
        val newParameters = Parameters.getParameters(context)

        assertTrue(newParameters == parameters)

    }


}