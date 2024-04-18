package com.bae.animationtest.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun SpecSamples(navController: NavHostController, contentPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            onClick = { navController.navigate("tween") }
        ) {
            Text("Tween Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            onClick = { navController.navigate("spring") }
        ) {
            Text("Spring Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            onClick = { navController.navigate("snap") })
        {
            Text("Snap Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            onClick = { navController.navigate("keyframes") }
        ) {
            Text("Keyframes Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
            onClick = { navController.navigate("repeatable") })
        {
            Text("Repeatable Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}