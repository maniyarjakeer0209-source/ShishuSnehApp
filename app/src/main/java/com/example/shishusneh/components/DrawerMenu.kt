package com.example.shishusneh.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DrawerMenu(

    onHomeClick: () -> Unit,
    onProfileClick: () -> Unit,
    onNotificationClick: () -> Unit,
    onSettingsClick: () -> Unit,
    onAboutClick: () -> Unit,
    onLogoutClick: () -> Unit

) {

    ModalDrawerSheet(

        modifier = Modifier.width(300.dp),

        drawerContainerColor = Color.White,

        drawerShape = RoundedCornerShape(
            topEnd = 24.dp,
            bottomEnd = 24.dp
        )

    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Shishu-Sneh 👶",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(20.dp),
            color = Color(0xFF1565C0)
        )

        NavigationDrawerItem(
            label = { Text("Home") },
            selected = false,
            onClick = onHomeClick,
            icon = {
                Icon(Icons.Default.Home, null)
            }
        )

        NavigationDrawerItem(
            label = { Text("My Child Profile") },
            selected = false,
            onClick = onProfileClick,
            icon = {
                Icon(Icons.Default.Person, null)
            }
        )

        NavigationDrawerItem(
            label = { Text("Vaccination History") },
            selected = false,
            onClick = { },
            icon = {
                Icon(Icons.Default.MedicalServices, null)
            }
        )

        NavigationDrawerItem(
            label = { Text("Growth Tracker") },
            selected = false,
            onClick = { },
            icon = {
                Icon(Icons.Default.ShowChart, null)
            }
        )

        NavigationDrawerItem(
            label = { Text("Feeding Tracker") },
            selected = false,
            onClick = { },
            icon = {
                Icon(Icons.Default.Restaurant, null)
            }
        )

        NavigationDrawerItem(
            label = { Text("Milestones") },
            selected = false,
            onClick = { },
            icon = {
                Icon(Icons.Default.Star, null)
            }
        )

        NavigationDrawerItem(
            label = { Text("Notifications & Reminders") },
            selected = false,
            onClick = onNotificationClick,
            icon = {
                Icon(Icons.Default.Notifications, null)
            }
        )

        NavigationDrawerItem(
            label = { Text("Settings") },
            selected = false,
            onClick = onSettingsClick,
            icon = {
                Icon(Icons.Default.Settings, null)
            }
        )

        NavigationDrawerItem(
            label = { Text("About App") },
            selected = false,
            onClick = onAboutClick,
            icon = {
                Icon(Icons.Default.Info, null)
            }
        )

        HorizontalDivider(
            modifier = Modifier.padding(vertical = 12.dp)
        )

        NavigationDrawerItem(
            label = { Text("Logout") },
            selected = false,
            onClick = onLogoutClick,
            icon = {
                Icon(Icons.Default.Logout, null)
            }
        )
    }
}