package com.bae.animationtest.ui.theme.spec

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bae.animationtest.ui.theme.AnimationTestTheme

@Composable
fun RepeatableAnimation() {
    val repeatableSpec = repeatable<Dp>(
        animation = tween(durationMillis = 1000, easing = LinearEasing),
        repeatMode = RepeatMode.Reverse,
        iterations = 10
    )
    var sizeState by remember { mutableStateOf(100.dp) }
    val animatedSize by animateDpAsState(
        targetValue = sizeState,
        animationSpec = repeatableSpec,
        label = "repeatable"
    )

    LaunchedEffect(Unit) {
        sizeState = 200.dp
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp)
                .background(Color.LightGray)
        ) {
            Box(
                modifier = Modifier
                    .size(animatedSize)
                    .background(Color.Magenta),
                contentAlignment = Alignment.Center
            ) {
                Text("Animating", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun RepeatableAnimationPreview() {
    AnimationTestTheme {
        RepeatableAnimation()
    }
}