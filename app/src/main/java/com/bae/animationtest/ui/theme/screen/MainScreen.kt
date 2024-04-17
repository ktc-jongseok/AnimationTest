package com.bae.animationtest.ui.theme.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bae.animationtest.ui.theme.GreenLight
import com.bae.animationtest.ui.theme.Seashell
import com.bae.animationtest.ui.theme.animation.AlphaAnimation
import com.bae.animationtest.ui.theme.animation.ColorAnimation
import com.bae.animationtest.ui.theme.animation.RotationAnimation
import com.bae.animationtest.ui.theme.animation.ScaleAnimation
import com.bae.animationtest.ui.theme.animation.TranslationAnimation
import com.bae.animationtest.ui.theme.component.MainTabBar
import com.bae.animationtest.ui.theme.etc.AnimateContentSizeAnimation
import com.bae.animationtest.ui.theme.etc.AnimateFloatAsStateAnimation
import com.bae.animationtest.ui.theme.etc.AnimatedVisibilityAnimation
import com.bae.animationtest.ui.theme.etc.LottieAnimationSample
import com.bae.animationtest.ui.theme.etc.RememberInfiniteAnimation
import com.bae.animationtest.ui.theme.spec.KeyFramesAnimation
import com.bae.animationtest.ui.theme.spec.RepeatableAnimation
import com.bae.animationtest.ui.theme.spec.SnapAnimation
import com.bae.animationtest.ui.theme.spec.SpringAnimation
import com.bae.animationtest.ui.theme.spec.TweenAnimation

@Composable
fun MainScreen() {
    var tabPage by remember { mutableStateOf(TabPage.Animation) }
    val backgroundColor = if (tabPage == TabPage.Animation) Seashell else GreenLight
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            MainTabBar(
                backgroundColor = backgroundColor,
                tabPage = tabPage,
                onTabSelected = { tabPage = it }
            )
        }
    ) { padding ->
        AppNavHost(navController = navController, contentPadding = padding)

        when (tabPage) {
            TabPage.Animation -> {
                navController.navigate("animation") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }

            TabPage.Spec -> {
                navController.navigate("spec") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }

            else -> {
                navController.navigate("etc") {
                    popUpTo(navController.graph.startDestinationId)
                    launchSingleTop = true
                }
            }
        }
    }
}

@Composable
fun AppNavHost(navController: NavHostController, contentPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = "animation") {
        composable("animation") { AnimationSamples(navController, contentPadding) }
        composable("scale") { ScaleAnimation() }
        composable("translate") { TranslationAnimation() }
        composable("rotate") { RotationAnimation() }
        composable("alpha") { AlphaAnimation() }
        composable("color") { ColorAnimation() }

        composable("spec") { SpecSamples(navController, contentPadding) }
        composable("tween") { TweenAnimation() }
        composable("spring") { SpringAnimation() }
        composable("snap") { SnapAnimation() }
        composable("keyframes") { KeyFramesAnimation() }
        composable("repeatable") { RepeatableAnimation() }

        composable("etc") { EtcSamples(navController, contentPadding) }
        composable("animatedVisibility") { AnimatedVisibilityAnimation() }
        composable("animateContentSize") { AnimateContentSizeAnimation() }
        composable("infinite") { RememberInfiniteAnimation() }
        composable("progress") { AnimateFloatAsStateAnimation() }
        composable("lottie") { LottieAnimationSample() }
    }
}

enum class TabPage {
    Animation, Spec, ETC
}