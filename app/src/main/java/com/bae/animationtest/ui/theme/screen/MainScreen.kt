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
    }
}

@Composable
fun AppNavHost(navController: NavHostController, contentPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = "animation") {
        composable("animation") { AnimationSamples(navController, contentPadding) }
        composable("scale") { ScaleAnimation(navController) }
        composable("translate") { TranslationAnimation(navController) }
        composable("rotate") { RotationAnimation(navController) }
        composable("alpha") { AlphaAnimation(navController) }
        composable("color") { ColorAnimation(navController) }
    }
}

enum class TabPage {
    Animation, Tab2
}