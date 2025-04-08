package org.iutnantes.doctowolib.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import org.iutnantes.doctowolib.controller.data.App
import org.iutnantes.doctowolib.ui.fragment.ReminderItem
import org.iutnantes.doctowolib.ui.fragment.button.ButtonAdd
import org.iutnantes.doctowolib.ui.fragment.dateCarrousel
import org.iutnantes.doctowolib.ui.fragment.getCurrentDay
import org.iutnantes.doctowolib.ui.theme.PADDING
import java.lang.Math.abs


@Composable
fun ReminderView(navController: NavController) {

    var day : Int = 0

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Row() {
            day = dateCarrousel()
        }

        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(PADDING, PADDING)
        ) {
            for (medication in App.medicationList) {
                // On applique le traitement à :
                // Tous les médicaments ayant une Fréquence régulière
                // ET Vérifie si ce résultat est un multiple du troisième élément de medication
                // ET Vérifie si le jour actuel est strictement inférieur à day + 1
                if (medication[1] == "Fréquence régulière"
                    && kotlin.math.abs(getCurrentDay() - day + 1).mod(medication[2].toInt()) == 0
                    && getCurrentDay() < day + 1) {
                    if (medication[5] == "Matin") {
                        ReminderItem(
                            medication[0],
                            "${medication[3]} ${medication[4]}",
                            "${App.hours[0]}h${App.hours[1]}"
                        )
                    }
                    if (medication[6] == "Midi") {
                        ReminderItem(
                            medication[0],
                            "${medication[3]} ${medication[4]}",
                            "${App.hours[2]}h${App.hours[3]}"
                        )
                    }
                    if (medication[7] == "Soir") {
                        ReminderItem(
                            medication[0],
                            "${medication[3]} ${medication[4]}",
                            "${App.hours[4]}h${App.hours[5]}"
                        )
                    }

                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ButtonAdd(
                { navController.navigate("add_reminder") }
            )
        }

    }
}