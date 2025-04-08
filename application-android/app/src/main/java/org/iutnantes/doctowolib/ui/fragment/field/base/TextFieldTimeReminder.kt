package org.iutnantes.doctowolib.ui.fragment.field.base

import androidx.compose.foundation.layout.width
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
import org.iutnantes.doctowolib.ui.theme.GET_LIMIT_MINUTE

/**
 * Composant de type TextField, dédié aux champs textes des alarmes,
 * @param content : chaine de caractere correspondant au contenu du TextField
 * @param text : indicateur texte pour aider les utilisateurs à savoir quoi écrire dans le TextField
 * @param limitIntConditionnal : entier correspondant à la limite maximum du nombre passée dans le content
 */
@Composable
fun TextFieldTimeReminder(
    content: String, text: String,
    limitIntConditionnal: Int = GET_LIMIT_MINUTE) {
    var content by rememberSaveable{ mutableStateOf(content) }
    TextField(
        modifier = Modifier
            .width(52.dp),
        value = content,
        onValueChange = {
            if(it.length<=2 && it.isDigitsOnly()) {
                if (it.isEmpty()) {
                    content = it
                } else {
                    if (it.toInt() < limitIntConditionnal) {
                        content = it
                    }
                }
            }
        },
        placeholder = { Text(text, color = GRAY, fontSize = TextUnit(14f, TextUnitType.Sp)) },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = LIGHT_GRAY
        )
    )
}

