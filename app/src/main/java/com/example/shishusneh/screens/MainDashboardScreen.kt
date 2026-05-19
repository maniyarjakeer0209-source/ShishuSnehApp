package com.example.shishusneh.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MedicalServices
import androidx.compose.material.icons.filled.Restaurant
import androidx.compose.material.icons.filled.ShowChart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.shishusneh.components.DrawerMenu
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

@Composable
fun MainDashboardScreen(

    onLogout: () -> Unit
) {

    var selectedItem by remember {
        mutableStateOf(0)
    }

    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )

    val scope = rememberCoroutineScope()

    val items = listOf(
        "Home",
        "Vaccine",
        "Growth",
        "Feeding",
        "Track"
    )

    ModalNavigationDrawer(

        drawerState = drawerState,

        drawerContent = {

            DrawerMenu(

                onHomeClick = {

                    selectedItem = 0

                    scope.launch {
                        drawerState.close()
                    }
                },

                onProfileClick = {

                    selectedItem = 200

                    scope.launch {
                        drawerState.close()
                    }
                },

                onNotificationClick = {

                    selectedItem = 300

                    scope.launch {
                        drawerState.close()
                    }
                },

                onSettingsClick = {

                    selectedItem = 400

                    scope.launch {
                        drawerState.close()
                    }
                },

                onAboutClick = {

                    selectedItem = 500

                    scope.launch {
                        drawerState.close()
                    }
                },

                onLogoutClick = {

                    FirebaseAuth
                        .getInstance()
                        .signOut()

                    onLogout()
                }
            )
        }

    ) {

        Scaffold(

            bottomBar = {

                NavigationBar {

                    items.forEachIndexed { index, item ->

                        NavigationBarItem(

                            selected = selectedItem == index,

                            onClick = {

                                selectedItem = index
                            },

                            icon = {

                                when(index) {

                                    0 -> Icon(Icons.Default.Home, null)

                                    1 -> Icon(Icons.Default.MedicalServices, null)

                                    2 -> Icon(Icons.Default.ShowChart, null)

                                    3 -> Icon(Icons.Default.Restaurant, null)

                                    4 -> Icon(Icons.Default.Star, null)
                                }
                            },

                            label = {
                                Text(item)
                            }
                        )
                    }
                }
            }

        ) { padding ->

            Box(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
            ) {

                when(selectedItem) {

                    0 -> HomeScreen(

                        onAddChildClick = {

                            selectedItem = 100
                        },

                        onProfileClick = {

                            selectedItem = 200
                        },

                        onMenuClick = {

                            scope.launch {
                                drawerState.open()
                            }
                        }
                    )

                    1 -> VaccineScreen()

                    2 -> GrowthScreen()

                    3 -> FeedingScreen()

                    4 -> MilestoneScreen()

                    100 -> AddChildScreen(

                        onChildAdded = {

                            selectedItem = 0
                        }
                    )

                    200 -> ProfileScreen()

                    300 -> NotificationScreen()

                    400 -> SettingsScreen()

                    500 -> AboutScreen()
                }
            }
        }
    }
}