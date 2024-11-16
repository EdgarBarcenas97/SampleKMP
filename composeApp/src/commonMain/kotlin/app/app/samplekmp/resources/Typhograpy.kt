package app.app.samplekmp.resources

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.montserrat_black
import samplekmp.composeapp.generated.resources.montserrat_black_italic
import samplekmp.composeapp.generated.resources.montserrat_bold
import samplekmp.composeapp.generated.resources.montserrat_bold_italic
import samplekmp.composeapp.generated.resources.montserrat_extra_bold
import samplekmp.composeapp.generated.resources.montserrat_extra_bold_italic
import samplekmp.composeapp.generated.resources.montserrat_extra_light
import samplekmp.composeapp.generated.resources.montserrat_extra_light_italic
import samplekmp.composeapp.generated.resources.montserrat_italic
import samplekmp.composeapp.generated.resources.montserrat_light
import samplekmp.composeapp.generated.resources.montserrat_light_italic
import samplekmp.composeapp.generated.resources.montserrat_medium
import samplekmp.composeapp.generated.resources.montserrat_medium_italic
import samplekmp.composeapp.generated.resources.montserrat_regular
import samplekmp.composeapp.generated.resources.montserrat_semi_bold
import samplekmp.composeapp.generated.resources.montserrat_semi_bold_italic
import samplekmp.composeapp.generated.resources.montserrat_thin
import samplekmp.composeapp.generated.resources.montserrat_thin_italic

val TemisFontFamily: FontFamily
    @Composable
    get() = FontFamily(
        Font(Res.font.montserrat_extra_light, FontWeight.ExtraLight),
        Font(Res.font.montserrat_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),
        Font(Res.font.montserrat_light, FontWeight.Light),
        Font(Res.font.montserrat_light_italic, FontWeight.Light, FontStyle.Italic),
        Font(Res.font.montserrat_regular),
        Font(Res.font.montserrat_italic),
        Font(Res.font.montserrat_medium, FontWeight.Medium),
        Font(Res.font.montserrat_medium_italic, FontWeight.Medium, FontStyle.Italic),
        Font(Res.font.montserrat_semi_bold, FontWeight.SemiBold),
        Font(Res.font.montserrat_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
        Font(Res.font.montserrat_bold, FontWeight.Bold),
        Font(Res.font.montserrat_bold_italic, FontWeight.Bold, FontStyle.Italic),
        Font(Res.font.montserrat_extra_bold, FontWeight.ExtraBold),
        Font(Res.font.montserrat_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
        Font(Res.font.montserrat_thin, FontWeight.Thin),
        Font(Res.font.montserrat_thin_italic, FontWeight.Thin, FontStyle.Italic),
        Font(Res.font.montserrat_black, FontWeight.Black),
        Font(Res.font.montserrat_black_italic, FontWeight.Black, FontStyle.Italic)
    )

internal fun typography(fontFamily: FontFamily) = Typography(

    displayLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = headlineH2, //32.sp
        fontWeight = FontWeight.Normal, //W400
        lineHeight = lineHeightHeading,
        color = Neutro160,
        textAlign = TextAlign.Center),

    // Headline/H5
    headlineLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = headlineH5, //24sp
        fontWeight = FontWeight.Normal, //W400
        lineHeight = lineHeightHeadingSmall,
        color = Neutro160,
        textAlign = TextAlign.Center),

    // Headline/H6
    headlineMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = headlineH6, //20sp
        fontWeight = FontWeight.Normal, //W400
        lineHeight = lineHeightHeadingSmall,
        color = Neutro160,
        textAlign = TextAlign.Center),

    //Subtitle/Large
    titleLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = subtitleLarge, //18sp
        fontWeight = FontWeight.Normal, //W400
        lineHeight = lineHeightSubtitle,
        color = Neutro160,
        textAlign = TextAlign.Center),

    //// Subtitle/SemiBold
    titleMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = subtitle, //16sp
        fontWeight = FontWeight.SemiBold, //W600
        lineHeight = lineHeightSubtitle,
        color = Neutro160,
        textAlign = TextAlign.Center),

    //// Subtitle/Regular
    titleSmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = subtitle, //16sp
        fontWeight = FontWeight.Normal, //W400
        lineHeight = lineHeightSubtitle,
        color = Neutro160,
        textAlign = TextAlign.Center),

    //// Body/SemiBold
    bodyLarge = TextStyle(
        fontFamily = fontFamily,
        fontSize = body, //14.sp
        fontWeight = FontWeight.SemiBold, //W600
        lineHeight = lineHeightBody,
        color = Neutro160,
        textAlign = TextAlign.Center),

    //// Body/Regular
    bodyMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = body, //14.sp
        fontWeight = FontWeight.Normal,//W400
        lineHeight = lineHeightBody,
        color = Neutro160,
        textAlign = TextAlign.Center),

    //// Caption/Regular
    bodySmall = TextStyle(
        fontFamily = fontFamily,
        fontSize = caption, //12.sp
        fontWeight = FontWeight.Normal,//W400
        lineHeight = lineHeightCaption,
        color = Neutro160,
        textAlign = TextAlign.Center),

    //// Button
    labelMedium = TextStyle(
        fontFamily = fontFamily,
        fontSize = body, //14.sp
        fontWeight = FontWeight.SemiBold,//W600
        lineHeight = lineHeightBody,
        color = Neutro00,
        textAlign = TextAlign.Center)
)
