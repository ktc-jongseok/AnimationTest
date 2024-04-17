package com.bae.animationtest.ui.theme.etc

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bae.animationtest.ui.theme.AnimationTestTheme

@Composable
fun AnimateFloatAsStateAnimation() {
    val questions = remember {
        listOf(
            SurveyQuestion("Coffee?", listOf("Americano", "Latte", "Cappuccino", "Mocha")),
            SurveyQuestion("Season?", listOf("Spring", "Summer", "Fall", "Winter")),
            SurveyQuestion("Color?", listOf("Red", "Yellow", "Blue", "Black")),
            SurveyQuestion("Anim?", listOf("Scale", "Translation", "Rotation", "Alpha")),
        )
    }
    var currentPage by remember { mutableIntStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            SurveyPage(question = questions[currentPage])
            Spacer(Modifier.height(40.dp))
            ProgressBar(currentPage, questions.size)
            Spacer(Modifier.height(40.dp))
            Row {
                if (currentPage != 0) {
                    Button(onClick = {
                        if (currentPage > 0) {
                            currentPage--
                        }
                    }) {
                        Text("Prev")
                    }
                }

                Spacer(Modifier.width(16.dp))
                Button(onClick = {
                    if (currentPage < questions.size - 1) {
                        currentPage++
                    }
                }) {
                    Text("Next")
                }
            }
        }
    }
}

@Composable
fun SurveyPage(question: SurveyQuestion) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(question.question, style = MaterialTheme.typography.bodyMedium)
        question.options.forEachIndexed { index, option ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                Checkbox(
                    checked = question.responses[index],
                    onCheckedChange = { isChecked ->
                        question.responses[index] = isChecked
                    }
                )
                Text(option)
            }
        }
    }
}

@Composable
fun ProgressBar(currentPage: Int, pageCount: Int) {
    val progress = (currentPage + 1) / pageCount.toFloat()
    // Use Animation
//    val progress by animateFloatAsState(
//        targetValue = (currentPage + 1) / pageCount.toFloat(),
//        label = "animate"
//    )
    LinearProgressIndicator(progress = { progress })
}
data class SurveyQuestion(
    val question: String,
    val options: List<String>,
    val responses: MutableList<Boolean> = mutableStateListOf<Boolean>().also { list ->
        options.forEach { _ -> list.add(false) }
    }
)

@Preview
@Composable
fun AnimateFloatAsStateAnimationPreview() {
    AnimationTestTheme {
        AnimateFloatAsStateAnimation()
    }
}