package org.iutnantes.doctowolib.ui.fragment.button

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import org.iutnantes.doctowolib.ui.fragment.button.base.BasicIconButton
import org.iutnantes.doctowolib.ui.theme.FOOTER_ITEM_SIZE
@Composable
fun ButtonAdd(
    onClick: () -> Unit
) {
    BasicIconButton(
        icon = rememberVectorPainter(Icons.Default.Add),
        onClick = onClick,
        modifier = Modifier.size(FOOTER_ITEM_SIZE),
    )
}