package org.iutnantes.doctowolib.ui.fragment.button

import androidx.compose.runtime.Composable
import org.iutnantes.doctowolib.ui.fragment.button.base.BasicButton
import org.iutnantes.doctowolib.ui.theme.SIMPLE_PURPLE
import org.iutnantes.doctowolib.ui.theme.TEXT_SIZE
import org.iutnantes.doctowolib.ui.theme.WHITE

@Composable
fun ButtonValidate() {
    BasicButton(
        text = "Valider",
        onClick = { /*TODO*/ },
        buttonColor = SIMPLE_PURPLE,
        textColor = WHITE,
        fontSize = TEXT_SIZE,
    )
}