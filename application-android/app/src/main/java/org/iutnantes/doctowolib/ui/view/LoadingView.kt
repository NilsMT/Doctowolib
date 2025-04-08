package org.iutnantes.doctowolib.ui.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import org.iutnantes.doctowolib.R
import kotlinx.coroutines.delay
import org.iutnantes.doctowolib.ui.fragment.Logo
import org.iutnantes.doctowolib.ui.fragment.text.base.BasicText
import org.iutnantes.doctowolib.ui.theme.*


@Composable
fun LoadingView() {
    var isVisible by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        while (true) {
            isVisible = !isVisible
            delay(ANIMATION_DURATION.toLong()) // Change the delay to adjust the blinking speed
        }
    }

    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = ANIMATION_DURATION) )// Adjust the duration of the animation )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BLACK),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_round_for_loading_view),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = PADDING)
        )

        Logo(LOGO_SIZE)

        Spacer(modifier = Modifier.height(PADDING))

        HorizontalDivider(
            modifier = Modifier.padding(horizontal = PADDING),
            thickness = DIVIDER_THICKNESS,
            color = WHITE
        )
        Spacer(modifier = Modifier.height(PADDING))

        BasicText(
            "Lancement de l'application",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = PADDING)
        )

        BasicText(
            text = "Veuillez patienter...",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(bottom = PADDING)
                .alpha(alpha)
        )
    }
}