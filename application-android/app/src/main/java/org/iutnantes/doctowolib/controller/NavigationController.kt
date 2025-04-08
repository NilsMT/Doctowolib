package org.iutnantes.doctowolib.controller

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import org.iutnantes.doctowolib.ui.view.AddReminderView
import org.iutnantes.doctowolib.ui.view.ReminderView
import org.iutnantes.doctowolib.ui.view.SettingsView
import org.iutnantes.doctowolib.ui.view.WelcomeView
import org.iutnantes.doctowolib.ui.view.WipView

// Display a message if needed
//
// when for example the user is not connected,
// once the functionnality is implemented
@Composable
fun AfficherMessageVisuel(message : String) {
    val context = LocalContext.current
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun NavigationController(navController: NavHostController) {
    val routes = listOf(
        // Define the routes and their associated composables here
        RouteInfo("reminders", { ReminderView(navController) }),
        RouteInfo("prescriptions", { WipView(navController) }),
        RouteInfo("settings_init", { SettingsView(navController, true) }),
        RouteInfo("settings", { SettingsView(navController) }),
        RouteInfo("professional_registry", { WipView(navController) }),
        RouteInfo("side_effects", { WipView(navController) }),
        RouteInfo("welcome", { WelcomeView(navController) }),
        RouteInfo("add_reminder", { AddReminderView(navController) })
    )

    NavHost(navController, startDestination = "welcome") {
        routes.forEach { route ->
            composable(route.route) {
                route.composable()
            }
        }
    }
}

// Data class to hold route information and associated composable
data class RouteInfo(val route: String, val composable: @Composable () -> Unit)