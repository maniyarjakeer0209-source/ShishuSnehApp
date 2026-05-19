package com.example.shishusneh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shishusneh.auth.LoginScreen
import com.example.shishusneh.screens.MainDashboardScreen
import com.example.shishusneh.ui.theme.ShishuSnehTheme
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            ShishuSnehTheme {

                ShishuSnehApp()
            }
        }
    }
}

@Composable
fun ShishuSnehApp() {

    val auth = FirebaseAuth.getInstance()

    var isLoggedIn by remember {

        mutableStateOf(auth.currentUser != null)
    }

    if (isLoggedIn) {

        MainDashboardScreen(

            onLogout = {

                isLoggedIn = false
            }
        )

    } else {

        LoginScreen(

            onLoginSuccess = {

                isLoggedIn = true
            }
        )
    }
}

@Composable
fun SplashScreen() {

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF6F8FB)),

        contentAlignment = Alignment.Center
    ) {

        Column(

            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Surface(

                shape = RoundedCornerShape(100.dp),

                color = Color(0xFFDCEEFF)
            ) {

                Icon(

                    imageVector = Icons.Default.Face,

                    contentDescription = null,

                    tint = Color(0xFF0066B2),

                    modifier = Modifier
                        .padding(30.dp)
                        .size(70.dp)
                )
            }

            Spacer(modifier = Modifier.height(30.dp))

            Text(

                text = "Shishu-Sneh",

                fontSize = 42.sp,

                fontWeight = FontWeight.Bold,

                color = Color(0xFF0066B2)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(

                text = "Nurturing every step of your baby's journey",

                color = Color.Gray,

                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(40.dp))

            CircularProgressIndicator(

                color = Color(0xFF0066B2)
            )
        }
    }
}