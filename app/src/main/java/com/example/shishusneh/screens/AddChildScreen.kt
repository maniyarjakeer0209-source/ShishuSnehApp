package com.example.shishusneh.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun AddChildScreen(
    onChildAdded: () -> Unit
) {

    var babyName by remember {
        mutableStateOf("")
    }

    var age by remember {
        mutableStateOf("")
    }

    var vaccine by remember {
        mutableStateOf("")
    }

    var feeding by remember {
        mutableStateOf("")
    }

    var growth by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    val db = FirebaseFirestore.getInstance()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F9FB))
            .verticalScroll(rememberScrollState())
            .padding(20.dp)

    ) {

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Add Child 👶",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0D47A1)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Store baby dashboard information",
            color = Color.Gray,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(32.dp))

        PremiumTextField(
            value = babyName,
            onValueChange = {
                babyName = it
            },
            label = "Baby Name"
        )

        Spacer(modifier = Modifier.height(18.dp))

        PremiumTextField(
            value = age,
            onValueChange = {
                age = it
            },
            label = "Age in Months"
        )

        Spacer(modifier = Modifier.height(18.dp))

        PremiumTextField(
            value = vaccine,
            onValueChange = {
                vaccine = it
            },
            label = "Next Vaccine"
        )

        Spacer(modifier = Modifier.height(18.dp))

        PremiumTextField(
            value = feeding,
            onValueChange = {
                feeding = it
            },
            label = "Last Feeding"
        )

        Spacer(modifier = Modifier.height(18.dp))

        PremiumTextField(
            value = growth,
            onValueChange = {
                growth = it
            },
            label = "Growth Summary"
        )

        Spacer(modifier = Modifier.height(36.dp))

        Button(

            onClick = {

                if (
                    babyName.isBlank() ||
                    age.isBlank() ||
                    vaccine.isBlank() ||
                    feeding.isBlank() ||
                    growth.isBlank()
                ) {

                    Toast.makeText(
                        context,
                        "Please fill all fields",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    val childData = hashMapOf(

                        "babyName" to babyName,

                        "age" to "$age Months Old",

                        "vaccine" to vaccine,

                        "feeding" to feeding,

                        "growth" to growth
                    )

                    db.collection("children")

                        .document("latestChild")

                        .set(childData)

                        .addOnSuccessListener {

                            Toast.makeText(
                                context,
                                "Child Added Successfully 😎",
                                Toast.LENGTH_SHORT
                            ).show()

                            babyName = ""
                            age = ""
                            vaccine = ""
                            feeding = ""
                            growth = ""

                            onChildAdded()
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
                .height(62.dp),

            shape = RoundedCornerShape(22.dp),

            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1565C0)
            )
        ) {

            Text(
                text = "SAVE CHILD",
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun PremiumTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String
) {

    OutlinedTextField(

        value = value,

        onValueChange = onValueChange,

        modifier = Modifier.fillMaxWidth(),

        label = {
            Text(label)
        },

        shape = RoundedCornerShape(20.dp),

        colors = OutlinedTextFieldDefaults.colors(

            focusedContainerColor = Color.White,

            unfocusedContainerColor = Color.White,

            focusedBorderColor = Color(0xFF1565C0),

            unfocusedBorderColor = Color.LightGray
        )
    )
}