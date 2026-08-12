package com.example.facebook.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.facebook.core.theme.Grey
import com.example.facebook.core.theme.White
import com.example.facebook.ui.components.HomeScreenAppBar
import com.example.facebook.ui.components.PostItem
import com.example.facebook.ui.components.StorySection
import com.example.facebook.ui.components.WhatInYourMindSection

@Composable
fun HomeScreen() {
    Scaffold(
        containerColor = White,
        topBar = { HomeScreenAppBar() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),

            ) {
            item { WhatInYourMindSection() }
            item { HorizontalDivider(thickness = 1.5.dp, color = Grey) }
            item { StorySection() }
            item { HorizontalDivider(thickness = 1.5.dp, color = Grey) }
            items(12) { index ->
                PostItem()
                if (index < 11) {
                    HorizontalDivider(
                        thickness = 1.5.dp,
                        color = Grey,
                        modifier = Modifier.padding(vertical = 12.dp)
                    )
                }
            }
        }
    }
}