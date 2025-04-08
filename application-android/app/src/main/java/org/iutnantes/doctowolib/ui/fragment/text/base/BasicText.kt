package org.iutnantes.doctowolib.ui.fragment.text.base

import android.annotation.SuppressLint
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import org.iutnantes.doctowolib.ui.theme.TEXT_SIZE
import org.iutnantes.doctowolib.ui.theme.WHITE

// TODO : Replace every text zones with this one
@Composable
fun BasicText(
    text : String,
    color : Color = WHITE,
    fontSize : TextUnit = TEXT_SIZE.sp,
    fontWeight : FontWeight? = null,
    style : TextStyle = LocalTextStyle.current,
    textAlign : TextAlign? = null,
    @SuppressLint("ModifierParameter") modifier : Modifier = Modifier,

) {
    Text(
        text = text,
        color = color,
        fontSize = fontSize,
        textAlign = textAlign,
        fontWeight = fontWeight,
        modifier = modifier,
        style = style,
    )
}