package org.iutnantes.doctowolib.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.iutnantes.doctowolib.ui.fragment.Logo
import org.iutnantes.doctowolib.ui.fragment.text.base.BasicText
import org.iutnantes.doctowolib.ui.theme.BIG_LOGO_SIZE
import org.iutnantes.doctowolib.ui.theme.BIG_TEXT_SIZE
import org.iutnantes.doctowolib.ui.theme.PADDING

@Composable
fun WipView(navController: NavController) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth()
            .padding(PADDING, PADDING),
        verticalArrangement = Arrangement.spacedBy(PADDING),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Logo(BIG_LOGO_SIZE)

        BasicText(
            "Cette page n'est pas encore prête :(",
            modifier = Modifier.padding(top = 233.dp),
            fontWeight = FontWeight.Bold,
            fontSize = BIG_TEXT_SIZE.div(2).sp,
            textAlign = TextAlign.Center
        )
    }
}