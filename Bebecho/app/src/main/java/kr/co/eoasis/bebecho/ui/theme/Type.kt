package kr.co.eoasis.bebecho.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kr.co.eoasis.bebecho.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_semibold)) ,
        fontSize = 14.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_regular)) ,
        fontSize = 14.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_light)),
        fontSize = 14.sp,
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.wanted_sans_bold)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.wanted_sans_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = FontFamily(Font(R.font.wanted_sans_regular)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,

    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.poppins_medium)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily(Font(R.font.wanted_sans_semibold)),
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,)


)