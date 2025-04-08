package org.iutnantes.doctowolib.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.iutnantes.doctowolib.ui.fragment.Logo
import org.iutnantes.doctowolib.ui.fragment.button.base.BasicButton
import org.iutnantes.doctowolib.ui.fragment.text.base.BasicText
import org.iutnantes.doctowolib.ui.theme.BIG_LOGO_SIZE
import org.iutnantes.doctowolib.ui.theme.BIG_TEXT_SIZE
import org.iutnantes.doctowolib.ui.theme.PADDING

@Composable
fun WelcomeView(navController: NavController) {
    var showDialog by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(PADDING, PADDING),
        verticalArrangement = Arrangement.spacedBy(PADDING),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicText(
            "Bienvenue dans",
            modifier = Modifier.padding(top = 233.dp),
            fontWeight = FontWeight.Bold,
            fontSize = BIG_TEXT_SIZE.div(2).sp
        )

        Logo(BIG_LOGO_SIZE)

        BasicText(
            "Une application par OwO Corp",
            modifier = Modifier.padding(top = 15.dp)
        )

        BasicButton(
            "Démarrer",
            { showDialog = true},       //pour déclencher l'alertDialog
            modifier = Modifier.padding(top = 233.dp)
        )

        if (showDialog){
            AlertDialog(
                icon = {
                    Icons.Default.Info
                },
                title = {
                    BasicText(text = "Acceptation de compréhension")
                },
                text = {
                    BasicText(text = "DoctOwOlib est une application d'aide aux suivis médicamenteux. Cette application ne peut en aucun cas vous fournir un diagnostic médical. En cas de problème médical, nous  vous recommandons donc de consulter un médecin.")
                },
                onDismissRequest = {
                    showDialog = false
                },
                confirmButton = {
                    BasicButton(
                        text = "Accepter",
                        onClick = {
                            navController.navigate("settings_init")
                            showDialog = false
                        }
                    )
                },
                dismissButton = {
                    BasicButton(
                        text = "Refuser",
                        onClick = {
                            showDialog = false
                        }
                    )
                }
            )
        }
    }
}