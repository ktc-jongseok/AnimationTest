package com.bae.animationtest.ui.theme.etc

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bae.animationtest.ui.theme.AnimationTestTheme
import com.bae.animationtest.ui.theme.GreenLight

@Composable
fun AnimateContentSizeAnimation() {
    var expanded by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = GreenLight,
                    shape = RoundedCornerShape(15.dp)
                )
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = "Android Compose streamlines the integration of animations into your UI, enhancing user interactions with smooth and visually appealing transitions. Utilizing its powerful animation framework, Compose allows developers to easily implement complex animations with minimal code. This is facilitated by the framework's ability to synchronize animations seamlessly with app state changes, thanks to its declarative nature. Compose's built-in transition effects enable fluid, responsive designs that feel intuitive to users. Moreover, the animateContentSize modifier automatically animates changes in UI components' sizes, simplifying the creation of dynamic interfaces. For developers seeking finer control, Compose offers detailed options for timing, easing, and sequencing animations, ensuring a polished final product.",
                modifier = Modifier
                    // Use Animation
//                    .animateContentSize(
//                        animationSpec = spring(
//                            dampingRatio = Spring.DampingRatioLowBouncy,
//                            stiffness = Spring.StiffnessLow
//                        )
//                    )
                    .clickable {
                        expanded = !expanded
                    },
                maxLines = if (!expanded) 2 else 20
            )

        }
    }
}

@Preview
@Composable
fun AnimateContentSizeAnimationAnimationPreview() {
    AnimationTestTheme {
        AnimateContentSizeAnimation()
    }
}