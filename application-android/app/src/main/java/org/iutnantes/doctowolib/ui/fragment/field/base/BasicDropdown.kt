package org.iutnantes.doctowolib.ui.fragment.field.base

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.iutnantes.doctowolib.R
import org.iutnantes.doctowolib.ui.theme.LIGHT_GRAY
import org.iutnantes.doctowolib.ui.theme.RADIUS

// TODO: use a real dropdown... for the love of god what is this 😭
@Composable
fun BasicDropdown(
    itemList: List<Any>,
    selectionByDefault: Int = 0,
    isDropdownExpandedByDefault: Boolean = false,
    onSelectionChange: (Int) -> Unit,
) {
    var isDropdownExpanded by remember { mutableStateOf(isDropdownExpandedByDefault) }

    Box(modifier = Modifier
        .clip(RoundedCornerShape(RADIUS))
        .background(LIGHT_GRAY)
        .padding(top = 15.dp, bottom = 15.dp, start = 10.dp)
        .clickable {
            isDropdownExpanded = !isDropdownExpanded
        }
    ) {
        Text(text = itemList[selectionByDefault].toString())
        Image(
            painter = painterResource(id = R.drawable.dropdown),
            contentDescription = "DropDown Icon",
            modifier = Modifier.padding(60.dp, 0.dp, 18.dp, 0.dp)
        )
        DropdownMenu(
            expanded = isDropdownExpanded,
            onDismissRequest = {
                isDropdownExpanded = false
            }
        ) {
            itemList.forEachIndexed { index, item ->
                DropdownMenuItem(text = {
                    Text(text = item.toString())
                },
                    onClick = {
                        onSelectionChange(index)
                        isDropdownExpanded = false
                    }
                )
            }
        }
    }
}