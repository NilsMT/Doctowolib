package org.iutnantes.doctowolib.ui.fragment.field.base

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import org.iutnantes.doctowolib.ui.theme.GRAY
import org.iutnantes.doctowolib.ui.theme.LIGHT_GRAY

// TODO: to do because the current textField is just not optimised (like copy and paste values and not responsive)
/**
 * Composant de type TextField, utiliser pour avoir qu'un seul champ text,
 * @param content : chaine de caractere correspondant au contenu du TextField
 * @param conditionnalID : entier correspondant à un indice de conditionnel utilisé pour traiter l'arrivé de nouvel valeur de "content"
 */
@Composable
fun BasicTextField(content: String,conditionnalID : Int) {
    var content by rememberSaveable{ mutableStateOf(content) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 0.dp),
        value =  content,
        onValueChange = {
            when(conditionnalID){
                1 -> if (conditionalSimpleTextField(it)) content = it
                2 -> if (conditionalMedicamentTextField(it)) content = it
                3 -> if (conditionalWeightTextField(content = it)) content = it
                else -> println("rien ne se passe")
            }
        },
        placeholder = { Text("Ecrire ici...", color = GRAY, fontSize = TextUnit(14f, TextUnitType.Sp)) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = LIGHT_GRAY
        )
    )
}

fun conditionalSimpleTextField(content : String): Boolean {
    return content.length <= 3 && content.isDigitsOnly()
}

fun conditionalMedicamentTextField(content : String): Boolean {
    return content.length <= 45
}


fun conditionalWeightTextField(content : String): Boolean {
    val numberRegex =  "[\\d]*[.]?[\\d]*".toRegex()
    return numberRegex.matches(content) && content.length <= 6
}

