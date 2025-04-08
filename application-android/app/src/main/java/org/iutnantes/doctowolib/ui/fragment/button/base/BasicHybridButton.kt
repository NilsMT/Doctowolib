package org.iutnantes.doctowolib.ui.fragment.button.base

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.iutnantes.doctowolib.ui.fragment.text.base.BasicText
import org.iutnantes.doctowolib.ui.theme.ACCENT_PINK
import org.iutnantes.doctowolib.ui.theme.ICON_SIZE
import org.iutnantes.doctowolib.ui.theme.PRIMARY_PINK
import org.iutnantes.doctowolib.ui.theme.RADIUS
import org.iutnantes.doctowolib.ui.theme.REALLY_SMALL_PADDING
import org.iutnantes.doctowolib.ui.theme.WHITE

@Composable
fun BasicHybridButton(
    text: String,
    icon: Painter,
    onClick: () -> Unit,
    buttonColor: Color = PRIMARY_PINK,
    textColor: Color = WHITE,
    iconColor: Color = WHITE,
    fontSize: Float = 16f,
    iconSize: DpSize = DpSize(
        (ICON_SIZE).dp,
        (ICON_SIZE).dp
    ),
    enabled: Boolean = true,
    iconFirst: Boolean = false, // If true, the icon will be on the left, if false, it will be on the right
    isRowLayout: Boolean = true, // If true, the button will be a row, if false, it will be a column
    modifier: Modifier = Modifier,
    paddings: PaddingValues = PaddingValues(REALLY_SMALL_PADDING, REALLY_SMALL_PADDING)
) {
    val txtItem : @Composable () -> Unit = {
        BasicText(
            text = text,
            color = textColor,
            fontSize = fontSize.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    }

    val iconItem: @Composable () -> Unit = {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = iconColor,
            modifier = Modifier.size(iconSize)
        )
    }

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor),
        contentPadding = paddings,
        border = BorderStroke(REALLY_SMALL_PADDING, ACCENT_PINK),
        modifier = modifier.then(Modifier.padding(REALLY_SMALL_PADDING)),
        enabled = enabled,
        shape = RoundedCornerShape(RADIUS)
    ) {
        if (isRowLayout) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (iconFirst) {
                    iconItem()
                    Spacer(Modifier.width(REALLY_SMALL_PADDING * 2))
                    txtItem()
                } else {
                    txtItem()
                    Spacer(Modifier.width(REALLY_SMALL_PADDING * 2))
                    iconItem()
                }
            }
        } else {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                iconItem()
                Spacer(Modifier.height(REALLY_SMALL_PADDING * 2))
                txtItem()
            }
        }
    }
}
