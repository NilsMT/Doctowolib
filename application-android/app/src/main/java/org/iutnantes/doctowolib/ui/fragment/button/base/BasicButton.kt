package org.iutnantes.doctowolib.ui.fragment.button.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import org.iutnantes.doctowolib.ui.fragment.text.base.BasicText
import org.iutnantes.doctowolib.ui.theme.ACCENT_PINK
import org.iutnantes.doctowolib.ui.theme.PADDING
import org.iutnantes.doctowolib.ui.theme.PRIMARY_PINK
import org.iutnantes.doctowolib.ui.theme.RADIUS
import org.iutnantes.doctowolib.ui.theme.REALLY_SMALL_PADDING
import org.iutnantes.doctowolib.ui.theme.TEXT_SIZE
import org.iutnantes.doctowolib.ui.theme.WHITE

@Composable
fun BasicButton(
    text: String,
    onClick: () -> Unit,
    buttonColor: Color = PRIMARY_PINK,
    textColor: Color = WHITE,
    fontSize: Float = TEXT_SIZE,
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    paddings: PaddingValues = PaddingValues(PADDING, PADDING)
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        contentPadding = paddings,
        border = BorderStroke(REALLY_SMALL_PADDING, ACCENT_PINK),
        modifier = modifier
            .wrapContentWidth() //equivalent to width : fit-content in CSS
            .wrapContentHeight() //equivalent to height : fit-content in CSS
            .then(Modifier.padding(REALLY_SMALL_PADDING)),
        enabled = enabled,
        shape = RoundedCornerShape(RADIUS)
    ) {
        BasicText(
            text = text,
            color = textColor,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }
}