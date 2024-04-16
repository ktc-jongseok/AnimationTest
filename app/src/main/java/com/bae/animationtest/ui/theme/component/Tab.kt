package com.bae.animationtest.ui.theme.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bae.animationtest.R
import com.bae.animationtest.ui.theme.GreenLight
import com.bae.animationtest.ui.theme.Seashell
import com.bae.animationtest.ui.theme.screen.TabPage

@Composable
fun MainTabBar(
    backgroundColor: Color,
    tabPage: TabPage,
    onTabSelected: (tabPage: TabPage) -> Unit
) {
    Column(modifier = Modifier.windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal))) {
        Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
        TabRow(
            selectedTabIndex = tabPage.ordinal,
            containerColor = backgroundColor,
            contentColor = MaterialTheme.colorScheme.onSurface,
            indicator = { tabPositions ->
                MainTabIndicator(tabPositions, tabPage)
            }
        ) {
            MainTab(
                icon = Icons.Default.Home,
                title = stringResource(R.string.tab1_name),
                onClick = { onTabSelected(TabPage.Animation) }
            )
            MainTab(
                icon = Icons.Default.Face,
                title = stringResource(R.string.tab2_name),
                onClick = { onTabSelected(TabPage.Spec) }
            )
        }
    }
}

@Composable
private fun MainTab(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clickable(onClick = onClick)
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title)
    }
}

@Preview
@Composable
private fun MainTabPreview() {
    var tabPage by remember { mutableStateOf(TabPage.Animation) }
    val backgroundColor = if (tabPage == TabPage.Animation) Seashell else GreenLight

    TabRow(
        selectedTabIndex = 0,
        containerColor = backgroundColor,
        contentColor = MaterialTheme.colorScheme.onSurface,
    ) {
        MainTab(
            icon = Icons.Default.Home,
            title = stringResource(R.string.tab1_name),
            onClick = {

            }
        )
        MainTab(
            icon = Icons.Default.Face,
            title = stringResource(R.string.tab2_name),
            onClick = { }
        )
    }
}