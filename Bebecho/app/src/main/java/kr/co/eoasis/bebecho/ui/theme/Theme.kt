package kr.co.eoasis.bebecho.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = PANTONE184C,
    secondary = PANTONE184CLight,
    tertiary = PANTONE184C,
    background = White,
    surface = Gray3,
    onPrimary = White,
    onSecondary = PANTONE184C,
    onTertiary = White,
    onBackground = Gray9,
    onSurface = White,
    onSurfaceVariant = Gray6,
    surfaceVariant = Gray4 ,
    surfaceContainerLow = Gray0
)

private val LightColorScheme = lightColorScheme(
    primary = PANTONE184C,
    secondary = PANTONE184CLight,
    tertiary = PANTONE184C,
    background = White,
    surface = Gray3,
    onPrimary = White,
    onSecondary = PANTONE184C,
    onTertiary = White,
    onBackground = Gray9,
    onSurface = White,
    onSurfaceVariant = Gray6,
    surfaceVariant = Gray4,
    surfaceContainerLow = Gray0


    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun BebechoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
       /* dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }*/

        darkTheme -> LightColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}