package com.bae.animationtest.ui.theme.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun AnimationSamples(navController: NavHostController, contentPadding: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(contentPadding),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { navController.navigate("scale") }) {
            Text("Scale Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("translate") }) {
            Text("Translation Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("rotate") }) {
            Text("Rotation Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("alpha") }) {
            Text("Alpha Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { navController.navigate("color") }) {
            Text("Color Animation")
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}