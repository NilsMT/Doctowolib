package org.iutnantes.doctowolib.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.iutnantes.doctowolib.R
import org.iutnantes.doctowolib.controller.data.App
import org.iutnantes.doctowolib.ui.fragment.button.base.BasicButton
import org.iutnantes.doctowolib.ui.fragment.field.base.BasicTextField
import org.iutnantes.doctowolib.ui.fragment.field.base.TextFieldTimeReminder
import org.iutnantes.doctowolib.ui.fragment.text.base.BasicText
import org.iutnantes.doctowolib.ui.theme.BLACK
import org.iutnantes.doctowolib.ui.theme.LIGHT_GRAY
import org.iutnantes.doctowolib.ui.theme.NO_PADDING
import org.iutnantes.doctowolib.ui.theme.PADDING
import org.iutnantes.doctowolib.ui.theme.RED
import org.iutnantes.doctowolib.ui.theme.GET_LIMIT_HOUR
import org.iutnantes.doctowolib.ui.theme.ICON_SIZE

@Composable
fun SettingsView(navController: NavController, isInit : Boolean = false) {
    var userAge by rememberSaveable{ mutableStateOf("") }
    var userWeigth by rememberSaveable{ mutableStateOf("") }
    var morningHour by rememberSaveable{ mutableStateOf("") }
    var morningMinute by rememberSaveable{ mutableStateOf("") }
    var noonHour by rememberSaveable{ mutableStateOf("") }
    var noonMinute by rememberSaveable{ mutableStateOf("") }
    var eveningHour by rememberSaveable{ mutableStateOf("") }
    var eveningMinute by rememberSaveable{ mutableStateOf("") }

    val isAllergiesDropDownExpanded = remember {
        mutableStateOf(false)
    }

    val allergiesPosition = remember {
        mutableStateOf(0)
    }

    val allergiesList = listOf("Pénicilline","Sulfamides","Céphalosporines","Acide acétylsalicylique")
    var allergiesListSelected = remember { mutableStateListOf<String>() }



    Column (
        modifier = Modifier
            .padding(16.dp, 16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Text("Informations personnelles",
            fontSize = TextUnit(27.65f, TextUnitType.Sp),
            fontWeight = FontWeight.Bold)

        Text("Votre age :",
            fontSize = TextUnit(14f, TextUnitType.Sp),
            modifier = Modifier.padding(10.dp,19.dp,0.dp,0.dp))

        BasicTextField(content = userAge, 1)

        Text("Votre poids (en kg) :",
            fontSize = TextUnit(14f, TextUnitType.Sp),
            modifier = Modifier.padding(10.dp,20.dp,0.dp,0.dp))

        BasicTextField(content = userWeigth, 3)


        Text("Veuillez sélectionner vos allergies :",
            fontSize = TextUnit(14f, TextUnitType.Sp),
            modifier = Modifier.padding(10.dp,20.dp,0.dp,0.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .clickable {
                    isAllergiesDropDownExpanded.value = true
                }
                .padding(20.dp, 10.dp, 0.dp, 0.dp)
        ) {
            Box(modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(LIGHT_GRAY)
                .padding(15.dp, 15.dp, 5.dp, 15.dp)
            ) {
                Row {
                    Text(text = "Selectionné vos allergies")
                    Spacer(modifier = Modifier.size(PADDING))
                    Image(
                        painter = painterResource(id = R.drawable.dropdown),
                        contentDescription = "DropDown Icon",
                    )
                }
                DropdownMenu(
                    expanded = isAllergiesDropDownExpanded.value,
                    onDismissRequest = {
                        isAllergiesDropDownExpanded.value = false
                    }) {
                    allergiesList.forEachIndexed { index, alle ->
                        DropdownMenuItem(text = {
                            Text(text = alle)
                        },
                            onClick = {
                                isAllergiesDropDownExpanded.value = false
                                allergiesPosition.value = index
                                if (allergiesList[allergiesPosition.value] !in allergiesListSelected) allergiesListSelected.add(allergiesList[allergiesPosition.value])
                            })
                    }
                }
            }
        }

        ListAllergiesSelected(allergiesListSelected)

        if (!isInit) {
            Text("Alarmes",
                fontSize = TextUnit(27.65f, TextUnitType.Sp),
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top=15.dp))

            Row(modifier = Modifier.padding(top = 5.dp)){

                Text("Matin",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    modifier = Modifier.padding(start = 30.dp))

                Text("Midi",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    modifier = Modifier.padding(start = 100.dp))

                Text("Soir",
                    fontSize = TextUnit(14f, TextUnitType.Sp),
                    modifier = Modifier.padding(start = 100.dp))
            }

            Row(modifier = Modifier.padding(top = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween){

                TextFieldTimeReminder(content = morningHour, text = App.hours[0].toString(), limitIntConditionnal = GET_LIMIT_HOUR)

                Text(":",
                    fontSize = TextUnit(20f, TextUnitType.Sp),
                    modifier = Modifier.padding(start = 4.dp, top = 15.dp, end = 4.dp))

                TextFieldTimeReminder(content = morningMinute, text = App.hours[1].toString())

                TextFieldTimeReminder(content = noonHour, text = App.hours[2].toString(), limitIntConditionnal = GET_LIMIT_HOUR)

                Text(":",
                    fontSize = TextUnit(20f, TextUnitType.Sp),
                    modifier = Modifier.padding(start = 4.dp, top = 15.dp, end = 4.dp))

                TextFieldTimeReminder(content = noonMinute, text = App.hours[3].toString())

                TextFieldTimeReminder(content = eveningHour, text = App.hours[4].toString(), limitIntConditionnal = GET_LIMIT_HOUR)

                Text(":",
                    fontSize = TextUnit(20f, TextUnitType.Sp),
                    modifier = Modifier.padding(start = 4.dp, top = 15.dp, end = 4.dp))

                TextFieldTimeReminder(content = eveningMinute, text = App.hours[5].toString())
            }
        }

        //TODO: a traiter
        BasicButton(
            text = "ENREGISTRER",
            onClick = {
                navController.navigate("reminders")

                //TODO: check si c'est identique pour l'init et après ou si l'action est différente
                App.hours = mutableListOf(morningHour,morningMinute,noonHour,noonMinute,eveningHour,eveningMinute)
            }
        )
    }
}


/**
 * Composant permettant de faire afficher les allergies selectionnées par l'utilisateur et de les supprimer de la même liste
 * @param allergiesListSelected : liste de chaine de caractere correspondant à la liste des allergies sélectionnées par l'utilisateur
 */
@Composable
fun ListAllergiesSelected(allergiesListSelected : SnapshotStateList<String>) {
    allergiesListSelected.forEach {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray),
            verticalAlignment = Alignment.CenterVertically
        ) {
            BasicText(
                text = it.toString(),
                color = BLACK,
                modifier = Modifier
                    .weight(1f)
                    .padding(PADDING, NO_PADDING, NO_PADDING, NO_PADDING)
                //textAlign = TextAlign.Center,
            )

            IconButton(onClick = {
                allergiesListSelected.remove(it)
            }) {
                Icon(
                    painter = rememberVectorPainter(Icons.Outlined.Close),
                    contentDescription = "supprimer l'élément",
                    tint = RED,
                    modifier = Modifier.size(ICON_SIZE.dp)
                )
            }
        }
    }
}