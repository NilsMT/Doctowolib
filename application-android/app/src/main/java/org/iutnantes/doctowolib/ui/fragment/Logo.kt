package org.iutnantes.doctowolib.ui.fragment

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import org.iutnantes.doctowolib.ui.theme.SIMPLE_PURPLE
import org.iutnantes.doctowolib.ui.theme.WHITE

@Composable
fun Logo(size : Float){
    Text(
        buildAnnotatedString {
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = WHITE)) {
                append("Doct")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = SIMPLE_PURPLE)) {
                append("OwO")
            }
            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = WHITE)) {
                append("lib")
            }
        },
        fontSize = TextUnit(size, TextUnitType.Sp)
    )
}