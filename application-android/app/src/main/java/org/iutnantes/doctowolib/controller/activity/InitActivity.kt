package org.iutnantes.doctowolib.controller.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.runtime.LaunchedEffect
import org.iutnantes.doctowolib.ui.view.LoadingView

// This is the activity that will be called when the app is started, it will be the first activity that will be called
// If you need to load stuff in the app, do it here (because it will really wait for them to load)
class InitActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Load stuff here

        installSplashScreen()

        setContent {
            LoadingView()

            LaunchedEffect(Unit) {
                startActivity(Intent(this@InitActivity, MainActivity::class.java))
                finish()
            }
        }
    }
}