package org.iutnantes.doctowolib.ui.fragment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import org.iutnantes.doctowolib.ui.theme.PRIMARY_PINK
import org.iutnantes.doctowolib.ui.theme.WHITE

@Composable
fun NextDose(medication: String, time: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(88.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(PRIMARY_PINK)
            .clickable {  }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Prochaine prise",
                    fontSize = TextUnit(16f, TextUnitType.Sp),
                    fontWeight = FontWeight.Bold,
                    color = WHITE.copy(alpha = 0.75f),
                )
                Box(contentAlignment = Alignment.CenterStart) {
                    Text(
                        text = medication,
                        fontSize = TextUnit(28.04f, TextUnitType.Sp),
                        fontWeight = FontWeight.ExtraBold,
                        fontStyle = FontStyle.Italic,
                        color = WHITE
                    )
                    Text(
                        text = time,
                        fontSize = TextUnit(16f, TextUnitType.Sp),
                        fontWeight = FontWeight(300),
                        color = WHITE.copy(alpha = 0.6f),
                        modifier = Modifier.offset(y = 20.dp)
                    )
                }
            }
            Icon(
                imageVector = Icons.Filled.Check,
                contentDescription = "Check icon",
                tint = WHITE,
                modifier = Modifier.size(80.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NextDosePreview() {
    NextDose("Paracétamol", "Lundi 11:00")
}