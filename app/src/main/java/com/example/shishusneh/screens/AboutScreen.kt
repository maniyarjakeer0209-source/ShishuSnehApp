package com.example.shishusneh.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AboutScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "ℹ About Shishu-Sneh",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text =
                "Shishu-Sneh is a Smart Child Healthcare Tracker app developed for helping parents monitor baby health, vaccines, feeding, growth and milestones.",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Version 1.0",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Developed using Kotlin + Firebase",
            fontSize = 16.sp
        )
    }
}