package com.bae.animationtest.ui.theme.etc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bae.animationtest.ui.theme.AnimationTestTheme
import com.bae.animationtest.ui.theme.GreenLight
import com.bae.animationtest.ui.theme.Orange
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun AnimatedVisibilityAnimation() {
    var showDetails by remember {
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
            ClickableText(
                text = AnnotatedString(text = "Viewing this sample will show you the importance of animations."),
                onClick = {
                    showDetails = !showDetails
                }
            )

            val currentTime = LocalTime.now()
            val timeFormatter = DateTimeFormatter.ofPattern("hh:mm a")
            val formattedTime = currentTime.format(timeFormatter)
            // Not Animation
            if (showDetails) {
                Text(
                    text = formattedTime,
                    style = TextStyle(
                        color = Orange,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp,
                    )
                )
            }

            // Use Animation
//            AnimatedVisibility(showDetails) {
//                Text(
//                    text = formattedTime,
//                    style = TextStyle(
//                        color = Orange,
//                        fontWeight = FontWeight.ExtraBold,
//                        fontSize = 24.sp,
//                    )
//                )
//            }
        }
    }
}

@Preview
@Composable
fun AnimatedVisibilityAnimationPreview() {
    AnimationTestTheme {
        AnimatedVisibilityAnimation()
    }
}