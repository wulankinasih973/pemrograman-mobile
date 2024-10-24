package com.example.personalinfo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFFE91E63), // Warna Pink (hex untuk pink)
    secondary = Color(0xFFFFFFFF) // Warna Putih (hex untuk white)
)

@Composable
fun PersonalInfoTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
