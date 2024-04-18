package com.bae.animationtest.ui.theme.spec

import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun TweenAnimation() {
    var sizeState by remember { mutableStateOf(100.dp) }
    val animationSpec = TweenSpec<Dp>(durationMillis = 2_000)
    val animatedSize by animateDpAsState(
        targetValue = sizeState,
        animationSpec = animationSpec,
        label = "tween"
    )

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp)
                .background(Color.LightGray)
                .clickable {
                    sizeState = if (sizeState == 100.dp) 200.dp else 100.dp
                }
        ) {
            Box(
                modifier = Modifier
                    .size(animatedSize)
                    .background(Color.Blue),
                contentAlignment = Alignment.Center
            ) {
                Text("Tap Me", color = Color.White)
            }
        }
    }
}

@Preview
@Composable
fun TweenAnimationPreview() {
    AnimationTestTheme {
        TweenAnimation()
    }
}