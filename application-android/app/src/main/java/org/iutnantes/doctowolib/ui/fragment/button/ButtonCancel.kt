package org.iutnantes.doctowolib.ui.fragment.button

import androidx.compose.runtime.Composable
import org.iutnantes.doctowolib.ui.fragment.button.base.BasicButton
import org.iutnantes.doctowolib.ui.theme.RED
import org.iutnantes.doctowolib.ui.theme.TEXT_SIZE
import org.iutnantes.doctowolib.ui.theme.WHITE

@Composable
fun ButtonCancel(
    onClick: () -> Unit
) {
    BasicButton(
        text = "Annuler",
        onClick = onClick ,
        buttonColor = RED,
        textColor = WHITE,
        fontSize = TEXT_SIZE,
    )
}