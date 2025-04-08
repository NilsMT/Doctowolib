package org.iutnantes.doctowolib.ui.fragment

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import org.iutnantes.doctowolib.ui.fragment.button.base.BasicIconButton
import org.iutnantes.doctowolib.ui.theme.ACCENT_PINK
import org.iutnantes.doctowolib.ui.theme.BLACK
import org.iutnantes.doctowolib.ui.theme.FOOTER_ITEM_SIZE
import org.iutnantes.doctowolib.ui.theme.SMALL_PADDING
import org.iutnantes.doctowolib.ui.theme.WHITE

// Its a footer
@Composable
fun Footer(navController: NavHostController) {

    // The list of stuff on the footer :  route ==> (label, icon)
    val navigation: Map<String, Pair<String, ImageVector>> = mapOf(
        "reminders" to Pair("Rappels", Icons.Filled.DateRange),
        "prescriptions" to Pair("Ordonnances", Icons.Filled.Description),
        "side_effects" to Pair("Effets secondaires", Icons.Filled.MonitorHeart),
        "settings" to Pair("Profil", Icons.Filled.Person),
        "professional_registry" to Pair("Contacts", Icons.AutoMirrored.Filled.Chat)
    )


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(BLACK)
            .padding(SMALL_PADDING)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            navigation.forEach { (route, data) ->
                val (label, icon) = data
                FooterItem(icon, label, navController, route)
            }
        }
    }
}

@Composable
fun FooterItem(icon: ImageVector, label: String, navController: NavHostController, destination: String) {
    val context = LocalContext.current
    val currentRoute = navController.currentDestination?.route

    // NOTE: If you click the button when already on the page you want,
    // it will display what the page you are on is
    BasicIconButton(
        icon = rememberVectorPainter(icon),
        iconColor = if (currentRoute == destination) ACCENT_PINK else WHITE,
        description = label,
        onClick = {
            if (currentRoute != destination) navController.navigate(destination)
            else Toast.makeText(context, label, Toast.LENGTH_SHORT).show()
        },
        modifier = Modifier.size(FOOTER_ITEM_SIZE),
    )
}