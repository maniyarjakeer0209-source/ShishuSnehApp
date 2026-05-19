package com.example.shishusneh.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(

    primary = LightBlue,

    secondary = PurpleGrey40,

    background = TextWhite,

    surface = TextWhite,

    onPrimary = TextWhite,

    onBackground = BackgroundDark,

    onSurface = BackgroundDark
)

@Composable
fun ShishuSnehTheme(

    darkTheme: Boolean = false,

    content: @Composable () -> Unit
) {

    MaterialTheme(

        colorScheme = LightColorScheme,

        typography = Typography,

        content = content
    )
}