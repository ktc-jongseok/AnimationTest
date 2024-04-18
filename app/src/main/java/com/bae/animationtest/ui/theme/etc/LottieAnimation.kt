package com.bae.animationtest.ui.theme.etc

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.bae.animationtest.R
import com.bae.animationtest.ui.theme.AnimationTestTheme

@Composable
fun LottieAnimationSample() {
    val animationFiles = listOf(R.raw.droid, R.raw.hello_robot, R.raw.car, R.raw.insta)
    var animationIndex by remember { mutableIntStateOf(0) }
    val selectedAnimation = animationFiles[animationIndex]

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(selectedAnimation))
    val animationState by animateLottieCompositionAsState(
        composition,
        restartOnPlay = true,
        iterations = LottieConstants.IterateForever
    )

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            composition = composition,
            progress = { animationState }
        )

        Button(
            modifier = Modifier.align(Alignment.BottomCenter),
            onClick = {
                animationIndex = (animationIndex + 1) % animationFiles.size
            }) {
            Text("Next Anim")
        }
    }
}

@Preview
@Composable
fun LottieAnimationPreview() {
    AnimationTestTheme {
        LottieAnimationSample()
    }
}