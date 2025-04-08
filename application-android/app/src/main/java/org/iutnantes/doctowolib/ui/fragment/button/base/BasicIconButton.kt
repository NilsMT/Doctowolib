package org.iutnantes.doctowolib.ui.fragment.button.base

import org.iutnantes.doctowolib.ui.theme.PRIMARY_PINK
import org.iutnantes.doctowolib.ui.theme.WHITE
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import org.iutnantes.doctowolib.ui.theme.ACCENT_PINK
import org.iutnantes.doctowolib.ui.theme.ICON_SIZE
import org.iutnantes.doctowolib.ui.theme.RADIUS
import org.iutnantes.doctowolib.ui.theme.REALLY_SMALL_PADDING

@Composable
fun BasicIconButton(
    icon: Painter,
    onClick: () -> Unit,
    buttonColor: Color = PRIMARY_PINK,
    iconColor: Color = WHITE,
    iconSize: DpSize = DpSize(
        (ICON_SIZE).dp,
        (ICON_SIZE).dp
    ),
    enabled: Boolean = true,
    modifier: Modifier = Modifier,
    paddings: PaddingValues = PaddingValues(REALLY_SMALL_PADDING, REALLY_SMALL_PADDING),
    description: String = ""
) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor, contentColor = buttonColor),
        contentPadding = paddings,
        enabled = enabled,
        shape = RoundedCornerShape(RADIUS),
        border = BorderStroke(REALLY_SMALL_PADDING, ACCENT_PINK), // Apply border correctly here
        modifier = modifier // No need to use .border() separately
    ) {
        Icon(
            painter = icon,
            contentDescription = description,
            tint = iconColor,
            modifier = Modifier.size(iconSize)
        )
    }
}