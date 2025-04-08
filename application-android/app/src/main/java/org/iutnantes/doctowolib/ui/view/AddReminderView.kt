package org.iutnantes.doctowolib.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import androidx.navigation.NavController
import org.iutnantes.doctowolib.controller.data.App
import org.iutnantes.doctowolib.ui.fragment.button.ButtonAdd
import org.iutnantes.doctowolib.ui.fragment.field.base.BasicDropdown
import org.iutnantes.doctowolib.ui.fragment.field.base.BasicTextField
import org.iutnantes.doctowolib.ui.theme.ACCENT_PINK
import org.iutnantes.doctowolib.ui.theme.GRAY
import org.iutnantes.doctowolib.ui.theme.LIGHT_GRAY

@Composable
fun AddReminderView(navController: NavController) {
    var medicationName by rememberSaveable{ mutableStateOf("") }
    var medicationDosage by rememberSaveable{ mutableStateOf("") }

    val radioOptions = listOf("Fréquence régulière", "Au besoin")
    val (selectedUsage, onUsageSelected) = remember { mutableStateOf(radioOptions[0] ) }
    val checkOptions = listOf("Matin", "Midi", "Soir")
    val onSelectedRappel = remember { mutableStateListOf(false,false,false ) }
    val selectedRappel = remember { mutableListOf("","","") }

    val frequenciesPosition = remember { mutableStateOf(0) }
    val unitPosition = remember { mutableStateOf(0) }
    val hourPosition = remember { mutableStateOf(0) }

    val frequenciesListInDays = listOf(1,2,3,4,5,6,7,8,9,10)

    val unitsList = listOf("g","mg","l","ml","pillule","comprimé")

    val hoursList = listOf("1 heure","2 heures","3 heures","4 heures","5 heures","6 heures","7 heures","8 heures","9 heures","10 heures")

    Column (
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){

        //TODO: à traiter
        Text("Nouveau médicament",
            fontSize = TextUnit(27.65f, TextUnitType.Sp),
            fontWeight = FontWeight.Bold)

        //TODO: à traiter
        Text("Nom du médicament",
            fontSize = TextUnit(14f, TextUnitType.Sp),
            modifier = Modifier.padding(10.dp,30.dp,0.dp,0.dp))

        //TODO: à traiter
        BasicTextField(content = medicationName, 2)


        //TODO: à traiter
        Text("Usage",
            fontSize = TextUnit(14f, TextUnitType.Sp),
            modifier = Modifier.padding(10.dp,30.dp,0.dp,0.dp))

        //TODO: à traiter
        Row(
            Modifier
                .fillMaxWidth()
        ) {
            radioOptions.forEach { text ->
                Row(
                    Modifier
                        .selectable(
                            selected = (text == selectedUsage),
                            onClick = {
                                onUsageSelected(text)
                            }
                        )
                        .padding(horizontal = 16.dp)
                ) {
                    RadioButton(
                        selected = (text == selectedUsage),
                        onClick = {
                            onUsageSelected(text)
                        },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = ACCENT_PINK
                        )
                    )
                    Text(
                        text = text,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }
            }
        }

        if(selectedUsage=="Fréquence régulière"){

            //TODO: à traiter
            Text("Fréquence",
                fontSize = TextUnit(14f, TextUnitType.Sp),
                modifier = Modifier.padding(10.dp,30.dp,0.dp,0.dp))

            Row(
                Modifier
                    .fillMaxWidth()
            ) {
                //TODO: à traiter
                Text(
                    "Tous les ...",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    modifier = Modifier.padding(30.dp, 30.dp, 0.dp, 0.dp)
                )

                BasicDropdown(
                    itemList = frequenciesListInDays,
                    selectionByDefault = frequenciesPosition.value,
                    onSelectionChange = {
                        frequenciesPosition.value = it
                    }
                )
                //TODO: à traiter
                Text(
                    "jours.",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    modifier = Modifier.padding(20.dp, 30.dp, 0.dp, 0.dp)
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "Dosage",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    modifier = Modifier.padding(10.dp, 30.dp, 0.dp, 0.dp)
                )
                Text(
                    "Rappel",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    modifier = Modifier.padding(135.dp, 30.dp, 0.dp, 0.dp)
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                TextField(
                    modifier = Modifier
                        .padding(0.dp, 10.dp)
                        .width(75.dp),
                    value = medicationDosage,
                    onValueChange = {
                        if(it.length<=3 && it.isDigitsOnly()) {
                            medicationDosage = it
                        }
                    },
                    placeholder = { Text("Qté ...", color = GRAY, fontSize = TextUnit(14f, TextUnitType.Sp)) },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = LIGHT_GRAY
                    )
                )
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(5.dp, 15.dp, 0.dp, 0.dp)
                ) {
                    BasicDropdown(
                       itemList = hoursList,
                       selectionByDefault = hourPosition.value,
                       onSelectionChange = {
                           hourPosition.value = it
                       }
                    )

                    onSelectedRappel.forEachIndexed { index, checked ->
                        Row(
                        ) {
                            Checkbox(
                                checked = checked,
                                onCheckedChange = { isChecked ->
                                    onSelectedRappel[index] = isChecked
                                },
                                colors = CheckboxDefaults.colors(
                                    checkmarkColor = LIGHT_GRAY,
                                    checkedColor = ACCENT_PINK
                                )
                            )
                            Text(
                                text = checkOptions[index],
                                modifier = Modifier.padding(top = 16.dp)
                            )
                        }
                    }
                }

            }

            for(i in checkOptions.indices){
                if(onSelectedRappel[i]){
                    selectedRappel[i]=checkOptions[i]
                }
                else{
                    selectedRappel[i]=""
                }
            }

            ButtonAdd(
                onClick = {
                    App.medicationList.add(
                        listOf(
                            medicationName,
                            selectedUsage,
                            frequenciesListInDays[frequenciesPosition.value].toString(),
                            medicationDosage,
                            unitsList[unitPosition.value],
                            selectedRappel[0],
                            selectedRappel[1],
                            selectedRappel[2]
                        )
                    )

                    navController.navigate("reminders")
                }
            )
        }

        else{
            Row(
                Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    "Dosage",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    modifier = Modifier.padding(10.dp, 30.dp, 0.dp, 0.dp)
                )
                Text(
                    "Temps entre prises",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    modifier = Modifier.padding(135.dp, 30.dp, 0.dp, 0.dp)
                )
            }

            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 171.8.dp)
            ) {
                TextField(
                    modifier = Modifier
                        .padding(0.dp, 10.dp)
                        .width(75.dp),
                    value = medicationDosage,
                    onValueChange = {
                        if(it.length<=3 && it.isDigitsOnly()) {
                            medicationDosage = it
                        }
                    },
                    placeholder = { Text("Qté ...", color = GRAY, fontSize = TextUnit(14f, TextUnitType.Sp)) },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = LIGHT_GRAY
                    )
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(10.dp, 15.dp, 0.dp, 0.dp)
                ) {
                    BasicDropdown(
                        itemList = unitsList,
                        selectionByDefault = unitPosition.value,
                        onSelectionChange = {
                            unitPosition.value = it
                        }
                    )

                }

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(90.dp, 15.dp, 0.dp, 0.dp)
                ) {
                    BasicDropdown(
                        itemList = hoursList,
                        selectionByDefault = hourPosition.value,
                        onSelectionChange = {
                            hourPosition.value = it
                        }
                    )
                }
            }

            ButtonAdd(
                onClick = {
                    App.medicationList.add(
                        listOf(medicationName,
                            selectedUsage,
                            medicationDosage,
                            unitsList[unitPosition.value],
                            hoursList[hourPosition.value]
                        )
                    )

                    navController.navigate("reminders")
                }
            )
        }
    }
}