package com.bae.animationtest.ui.theme.animation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bae.animationtest.ui.theme.AnimationTestTheme

@Composable
fun AlphaAnimation() {
    var faded by remember { mutableStateOf(false) }
    val alpha by animateFloatAsState(
        targetValue = if (faded) 0.3f else 1f,
        animationSpec = tween(1000),
        label = "alpha"
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            Modifier
                .size(100.dp)
                .graphicsLayer(alpha = alpha)
                .background(Color.Magenta)
        )

        Spacer(modifier = Modifier.height(200.dp))

        Button(onClick = { faded = !faded }) {
            Text("Toggle Alpha")
        }
    }
}

@Preview
@Composable
fun AlphaAnimationPreview() {
    AnimationTestTheme {
        AlphaAnimation()
    }
}