package org.iutnantes.doctowolib.controller.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import org.iutnantes.doctowolib.controller.NavigationController
import org.iutnantes.doctowolib.ui.fragment.Footer
import org.iutnantes.doctowolib.ui.theme.BLACK
import org.iutnantes.doctowolib.ui.theme.DoctowolibTheme

// This is the main activity of the app, it will be the second activity that will be called when the app is started
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoctowolibTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = BLACK
                ) {
                    MyApp()
                }
            }
        }
    }
}

// This is the main function that will be called when the app is started, its basically the content of the app
@Composable
fun MyApp() {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute != "welcome") { // Hide the footer if on the welcome route
                Footer(navController)
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavigationController(navController)
        }
    }
}
