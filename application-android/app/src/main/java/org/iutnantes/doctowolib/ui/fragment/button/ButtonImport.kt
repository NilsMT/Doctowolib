package org.iutnantes.doctowolib.ui.fragment.button

import androidx.compose.runtime.Composable
import org.iutnantes.doctowolib.ui.fragment.button.base.BasicButton
import org.iutnantes.doctowolib.ui.theme.SIMPLE_PURPLE
import org.iutnantes.doctowolib.ui.theme.TEXT_SIZE
import org.iutnantes.doctowolib.ui.theme.WHITE

@Composable
fun ButtonImport(
    onClick: () -> Unit
) {
    BasicButton(
        text = "Importer une nouvelle ordonnance",
        onClick = onClick,
        buttonColor = SIMPLE_PURPLE,
        textColor = WHITE,
        fontSize = TEXT_SIZE,
    )
}