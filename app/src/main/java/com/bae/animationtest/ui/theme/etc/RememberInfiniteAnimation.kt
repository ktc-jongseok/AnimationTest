package com.bae.animationtest.ui.theme.etc

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bae.animationtest.R
import com.bae.animationtest.ui.theme.AnimationTestTheme

@Composable
fun RememberInfiniteAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "infinite")
    val rotationAnimation = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing)),
        label = "infinite"
    )
    val listColors = listOf(Color.Yellow, Color.Red, Color.Blue)

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .drawBehind {
                    // Use Animation
//                    rotate(rotationAnimation.value) {
                        drawCircle(Brush.horizontalGradient(listColors), style = Stroke(20f))
//                    }
                }
                .padding(10.dp)
                .size(200.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.mario),
            contentDescription = "mario",
        )
    }
}

@Preview
@Composable
fun RememberInfiniteAnimationPreview() {
    AnimationTestTheme {
        RememberInfiniteAnimation()
    }
}