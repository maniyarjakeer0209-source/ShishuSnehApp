package com.example.shishusneh.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SplashScreen(

    onTimeout: () -> Unit
) {

    LaunchedEffect(Unit) {

        kotlinx.coroutines.delay(2000)

        onTimeout()
    }

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),

        contentAlignment = Alignment.Center
    ) {

        Column(

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "👶",
                fontSize = 80.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "ShishuSneh",
                fontSize = 34.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Smart Child Healthcare",
                fontSize = 18.sp
            )
        }
    }
}