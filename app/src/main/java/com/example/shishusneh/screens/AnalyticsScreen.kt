package com.example.shishusneh.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.StrokeCap

@Composable
fun AnalyticsScreen() {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)

    ) {

        Text(
            text = "📊 Child Analytics",
            fontSize = 28.sp
        )
        Text(
            text = "Track your child health insights in real-time 👶",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Spacer(modifier = Modifier.height(24.dp))

        Card(

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.85f)
            )

        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Growth Progress",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                LinearProgressIndicator(

                    progress = { 0.85f },

                    modifier = Modifier.fillMaxWidth(),

                    trackColor = MaterialTheme.colorScheme.surfaceVariant,

                    strokeCap = StrokeCap.Round
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "85% Healthy Growth"
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(20.dp)

        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Vaccination Progress",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                LinearProgressIndicator(

                    progress = { 0.70f },

                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "70% Vaccines Completed"
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(20.dp)

        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "Feeding Progress",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                LinearProgressIndicator(

                    progress = { 0.90f },

                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = "90% Feeding Schedule Maintained"
                )
            }
        }
    }
}