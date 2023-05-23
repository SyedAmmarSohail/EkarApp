package com.example.ekar.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = GREY,
    primaryVariant = GREY,
    secondary = Orange,
    background = MediumGray,
    onBackground = TextWhite,
    surface = LIGHT_GREY,
    onSurface = TextWhite,
    onPrimary = Color.White,
    onSecondary = Color.White,
)

private val LightColorPalette = lightColors(
    primary = White,
    primaryVariant = White,
    secondary = Orange,
    background = White,
    onBackground = DARK_GREY,
    surface = White,
    onSurface = DARK_GREY,
    onPrimary = DARK_GREY,
    onSecondary = White,
)

@Composable
fun EkarAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    CompositionLocalProvider(
        LocalSpacing provides Dimensions(),
        LocalFontSize provides FontSize()
    ) {
        MaterialTheme(
            colors = colors,
            typography = Typography,
            content = content,
            shapes = Shapes,
        )
    }
}