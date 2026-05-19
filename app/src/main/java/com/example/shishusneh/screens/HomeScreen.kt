package com.example.shishusneh.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun HomeScreen(
    onAddChildClick: () -> Unit,
    onProfileClick: () -> Unit,
    onMenuClick: () -> Unit
) {

    var babyName by remember {
        mutableStateOf("Baby")
    }

    var age by remember {
        mutableStateOf("0 Months Old")
    }

    var vaccine by remember {
        mutableStateOf("No Vaccine")
    }

    var feeding by remember {
        mutableStateOf("No Feeding Data")
    }

    var growth by remember {
        mutableStateOf("Healthy")
    }

    val db = FirebaseFirestore.getInstance()

    LaunchedEffect(Unit) {

        db.collection("children")
            .document("latestChild")
            .addSnapshotListener { value, _ ->

                if (value != null && value.exists()) {

                    babyName =
                        value.getString("babyName") ?: "Baby"

                    age =
                        value.getString("age")
                            ?: "0 Months Old"

                    vaccine =
                        value.getString("vaccine")
                            ?: "No Vaccine"

                    feeding =
                        value.getString("feeding")
                            ?: "No Feeding Data"

                    growth =
                        value.getString("growth")
                            ?: "Healthy"
                }
            }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FB))
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                IconButton(
                    onClick = {
                        onMenuClick()
                    }
                ) {

                    Icon(
                        Icons.Default.Menu,
                        contentDescription = null
                    )
                }

                Text(
                    text = "Shishu-Sneh",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF0D47A1)
                )

                Surface(
                    shape = RoundedCornerShape(50.dp),
                    color = Color(0xFFDDEBFA)
                ) {

                    IconButton(
                        onClick = {

                        }
                    ) {

                        Icon(
                            Icons.Default.Person,
                            contentDescription = null,
                            tint = Color(0xFF0D47A1)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Hello, $babyName 👋",
                fontSize = 38.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF0D47A1)
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = age,
                fontSize = 20.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(26.dp))

            DashboardCard(
                title = "NEXT VACCINE",
                mainText = vaccine,
                badge = "Next Week",
                cardColor = Color(0xFFE8F3FF)
            )

            Spacer(modifier = Modifier.height(18.dp))

            DashboardCard(
                title = "LAST FEEDING",
                mainText = feeding,
                badge = "Recent",
                cardColor = Color.White
            )

            Spacer(modifier = Modifier.height(18.dp))

            DashboardCard(
                title = "GROWTH SUMMARY",
                mainText = growth,
                badge = "Healthy",
                cardColor = Color(0xFFFFF1F1)
            )

            Spacer(modifier = Modifier.height(28.dp))

            Text(
                text = "Quick Actions",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(18.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                QuickActionCard(
                    title = "Add Notes",
                    icon = Icons.Default.Edit
                )

                QuickActionCard(
                    title = "Reminders",
                    icon = Icons.Default.Notifications
                )
            }
        }

        FloatingActionButton(

            onClick = {
                onAddChildClick()
            },

            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(bottom = 90.dp, end = 24.dp),

            containerColor = Color(0xFF0D47A1)
        ) {

            Icon(
                Icons.Default.Add,
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}

@Composable
fun DashboardCard(
    title: String,
    mainText: String,
    badge: String,
    cardColor: Color
) {

    Card(

        modifier = Modifier.fillMaxWidth(),

        shape = RoundedCornerShape(28.dp),

        colors = CardDefaults.cardColors(
            containerColor = cardColor
        )
    ) {

        Column(
            modifier = Modifier.padding(22.dp)
        ) {

            Row(

                modifier = Modifier.fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceBetween,

                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = title,
                    color = Color.Gray,
                    fontSize = 14.sp
                )

                Surface(
                    shape = RoundedCornerShape(50.dp),
                    color = Color(0xFF1565C0)
                ) {

                    Text(
                        text = badge,
                        color = Color.White,
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        )
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = mainText,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun QuickActionCard(
    title: String,
    icon: ImageVector
) {

    Card(

        modifier = Modifier
            .width(160.dp)
            .height(140.dp),

        shape = RoundedCornerShape(24.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {

        Column(

            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),

            horizontalAlignment = Alignment.CenterHorizontally,

            verticalArrangement = Arrangement.Center
        ) {

            Surface(
                shape = RoundedCornerShape(50.dp),
                color = Color(0xFFE8F3FF)
            ) {

                Icon(
                    icon,
                    contentDescription = null,
                    tint = Color(0xFF1565C0),
                    modifier = Modifier.padding(18.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = title,
                fontWeight = FontWeight.Medium
            )
        }
    }
}