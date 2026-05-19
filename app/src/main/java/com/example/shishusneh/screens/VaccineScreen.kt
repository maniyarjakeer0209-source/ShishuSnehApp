package com.example.shishusneh.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shishusneh.model.ChildModel
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun VaccineScreen() {

    val db = FirebaseFirestore.getInstance()

    var childList by remember {
        mutableStateOf(listOf<ChildModel>())
    }

    LaunchedEffect(Unit) {

        db.collection("children")
            .get()
            .addOnSuccessListener { result ->

                val list = mutableListOf<ChildModel>()

                for (document in result) {

                    val child = document.toObject(ChildModel::class.java)

                    list.add(child)
                }

                childList = list
            }
    }

    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)

    ) {

        item {

            Text(
                text = "💉 Vaccine Reminders",
                fontSize = 28.sp
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        items(childList.size) { index ->

            val child = childList[index]

            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),

                shape = RoundedCornerShape(20.dp)

            ) {

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    Text(
                        text = child.childName,
                        fontSize = 24.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Next Vaccine Date"
                    )

                    Text(
                        text = child.vaccineDate,
                        fontSize = 20.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "⚠ Reminder: Vaccine Due Soon"
                    )
                }
            }
        }
    }
}