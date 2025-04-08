package org.iutnantes.doctowolib.ui.fragment

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import org.iutnantes.doctowolib.ui.theme.ACCENT_PINK
import org.iutnantes.doctowolib.ui.theme.DARK_GRAY
import org.iutnantes.doctowolib.ui.theme.TRANSPARENT
import org.iutnantes.doctowolib.ui.theme.WHITE

@Composable
fun ReminderItem(medication: String, dosage: String, hour: String) {
    val isNow = hour == "Now"
    val backgroundColor = if (isNow) ACCENT_PINK else WHITE
    val backgroundBoxWidthOffset = if (isNow) 6 else 0
    val borderColor = if (isNow) ACCENT_PINK else TRANSPARENT
    val textColor = if (isNow) ACCENT_PINK else DARK_GRAY

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .clickable {  }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(88.dp)
                .padding(end = backgroundBoxWidthOffset.dp)
                .offset(x = (backgroundBoxWidthOffset - 1).dp)
                .clip(RoundedCornerShape(16.dp))
                .background(WHITE)
                .border(
                    width = 1.dp,
                    color = borderColor,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = medication,
                    fontSize = TextUnit(23.04f, TextUnitType.Sp)
                )
                Text(
                    text = if (isNow) "Maintenant" else hour,
                    modifier = Modifier.padding(top = 6.dp),
                    fontSize = TextUnit(16f, TextUnitType.Sp),
                    color = textColor
                )
            }
            Text(
                text = dosage,
                modifier = Modifier.padding(start = 13.dp, top = 45.dp),
                fontSize = TextUnit(16f, TextUnitType.Sp),
                fontWeight = FontWeight(300)
            )
        }
    }
}