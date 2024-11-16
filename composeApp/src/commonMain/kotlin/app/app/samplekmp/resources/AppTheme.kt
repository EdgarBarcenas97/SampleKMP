package app.app.samplekmp.resources

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.montserrat_regular


@Composable
internal fun TemisTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = lightColorPalette
    val typography = Typography().defaultFontFamily(FontFamily(Font(Res.font.montserrat_regular)))
    MaterialTheme(colorScheme = colorScheme, typography = typography, shapes = Shapes, content = content)
}

private val darkColorPalette = darkColorScheme(
    primary = RhealPrimaryDark,
    primaryContainer = RhealTertiaryDark,
    secondary = RhealSecondaryDark)

private val lightColorPalette = lightColorScheme(
    primary = RhealPrimary,
    primaryContainer = RhealTertiary,
    secondary = RhealSecondary,
    background = Neutro00,
    surfaceVariant = Neutro00)

fun Typography.defaultFontFamily(fontFamily: FontFamily): Typography {
    return this.copy(
        displayLarge = this.displayLarge.copy(fontFamily = fontFamily),
        displayMedium = this.displayMedium.copy(fontFamily = fontFamily),
        displaySmall = this.displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = this.headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = this.headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = this.headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = this.titleLarge.copy(fontFamily = fontFamily),
        titleMedium = this.titleMedium.copy(fontFamily = fontFamily),
        titleSmall = this.titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = this.bodyLarge.copy(fontFamily = fontFamily),
        bodyMedium = this.bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = this.bodySmall.copy(fontFamily = fontFamily),
        labelLarge = this.labelLarge.copy(fontFamily = fontFamily),
        labelMedium = this.labelMedium.copy(fontFamily = fontFamily),
        labelSmall = this.labelSmall.copy(fontFamily = fontFamily)
    )
}
