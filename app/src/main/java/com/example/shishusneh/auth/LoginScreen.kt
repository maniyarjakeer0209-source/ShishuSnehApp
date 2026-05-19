package com.example.shishusneh.auth

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.auth.FirebaseAuth

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F7FA))
            .padding(horizontal = 24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Surface(
            shape = RoundedCornerShape(100.dp),
            color = Color(0xFFDDEBFA),
            modifier = Modifier.size(160.dp)
        ) {

            Box(
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "👶",
                    fontSize = 70.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "Welcome Back 👋",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0066B2)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Login to continue caring for your baby",
            fontSize = 18.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(42.dp))

        OutlinedTextField(

            value = email,

            onValueChange = {
                email = it
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),

            singleLine = true,

            placeholder = {
                Text("Email Address")
            },

            leadingIcon = {
                Icon(
                    Icons.Default.Email,
                    null
                )
            },

            shape = RoundedCornerShape(22.dp),

            colors = OutlinedTextFieldDefaults.colors(

                focusedContainerColor = Color.White,

                unfocusedContainerColor = Color.White,

                focusedBorderColor = Color(0xFFB0B0B0),

                unfocusedBorderColor = Color(0xFFB0B0B0),

                focusedTextColor = Color.Black,

                unfocusedTextColor = Color.Black,

                cursorColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(

            value = password,

            onValueChange = {
                password = it
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp),

            singleLine = true,

            visualTransformation = PasswordVisualTransformation(),

            placeholder = {
                Text("Password")
            },

            leadingIcon = {
                Icon(
                    Icons.Default.Lock,
                    null
                )
            },

            trailingIcon = {
                Icon(
                    Icons.Default.Visibility,
                    null
                )
            },

            shape = RoundedCornerShape(22.dp),

            colors = OutlinedTextFieldDefaults.colors(

                focusedContainerColor = Color.White,

                unfocusedContainerColor = Color.White,

                focusedBorderColor = Color(0xFFB0B0B0),

                unfocusedBorderColor = Color(0xFFB0B0B0),

                focusedTextColor = Color.Black,

                unfocusedTextColor = Color.Black,

                cursorColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {

            Text(
                text = "Forgot Password?",
                color = Color(0xFF0066B2),
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(34.dp))

        Button(

            onClick = {

                if (email.isBlank() || password.isBlank()) {

                    Toast.makeText(
                        context,
                        "Please enter email and password",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    auth.signInWithEmailAndPassword(email, password)

                        .addOnSuccessListener {

                            Toast.makeText(
                                context,
                                "Login Successful 😎",
                                Toast.LENGTH_SHORT
                            ).show()

                            onLoginSuccess()
                        }

                        .addOnFailureListener {

                            Toast.makeText(
                                context,
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),

            shape = RoundedCornerShape(22.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0066B2)
            )
        ) {

            Text(
                text = "LOGIN",
                fontSize = 20.sp,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(22.dp))

        OutlinedButton(

            onClick = {

                if (email.isBlank() || password.isBlank()) {

                    Toast.makeText(
                        context,
                        "Please enter email and password",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    auth.createUserWithEmailAndPassword(email, password)

                        .addOnSuccessListener {

                            Toast.makeText(
                                context,
                                "Account Created Successfully 😎",
                                Toast.LENGTH_SHORT
                            ).show()

                            onLoginSuccess()
                        }

                        .addOnFailureListener {

                            Toast.makeText(
                                context,
                                it.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                }
            },

            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp),

            shape = RoundedCornerShape(22.dp),

            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.White
            )
        ) {

            Icon(
                Icons.Default.Person,
                null,
                tint = Color(0xFFB8AFC2)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = "Create Account",
                fontSize = 18.sp,
                color = Color(0xFFB8AFC2)
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Trusted by 10,000+ parents ❤️",
            color = Color.Gray,
            fontSize = 18.sp
        )
    }
}