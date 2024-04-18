package com.bae.animationtest.ui.theme.spec

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bae.animationtest.ui.theme.AnimationTestTheme

@Composable
fun SpringAnimation() {
    val springConfigs = listOf(
        0.75f to 100f,
        0.5773f to 300f,
        0.306f to 600f,
        1.118f to 80f
    )
    val toggleState = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.height(200.dp))

            springConfigs.forEachIndexed { index, (damping, stiffness) ->
                val animatedOffset by animateDpAsState(
                    targetValue = if (toggleState.value) 300.dp else 50.dp,
                    animationSpec = spring(dampingRatio = damping, stiffness = stiffness),
                    label = "spring$index"
                )

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .offset(y = animatedOffset)
                        .size(50.dp)
                        .background(Color.Blue, CircleShape)
                ) {

                }
            }
        }

        Column(Modifier.align(Alignment.BottomCenter)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                springConfigs.forEachIndexed { index, _ ->
                    Text(
                        text = when (index) {
                            0 -> "Gentle"
                            1 -> "Quick"
                            2 -> "Bouncy"
                            else -> "Slow"
                        },
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
            }
            Spacer(modifier = Modifier.height(100.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { toggleState.value = !toggleState.value },
            ) {
                Text("Toggle Position")
            }
        }

    }

}

@Preview
@Composable
fun SpringAnimationPreview() {
    AnimationTestTheme {
        SpringAnimation()
    }
}