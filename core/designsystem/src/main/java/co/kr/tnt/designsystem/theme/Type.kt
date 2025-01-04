package co.kr.tnt.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import co.kr.tnt.core.designsystem.R

val Pretendard = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Normal)
)

private val PretendardStyle = TextStyle(
    fontFamily = Pretendard,
)

// Set of Material typography styles to start with
internal val Typography = TnTTypography(
    h1 = PretendardStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = (28 * 1.5).sp,
        letterSpacing = (28 * -0.02).sp,
    ),
    h2 = PretendardStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        lineHeight = (24 * 1.5).sp,
        letterSpacing = (24 * -0.02).sp,
    ),
    h3 = PretendardStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = (20 * 1.5).sp,
        letterSpacing = (20 * -0.02).sp,
    ),
    h4 = PretendardStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = (18 * 1.5).sp,
        letterSpacing = (18 * -0.02).sp,
    ),
    body1Normal = PretendardStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        lineHeight = (28 * 1.5).sp,
        letterSpacing = (28 * -0.02).sp,
    ),
    body1Reading = PretendardStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = (16 * 1.6).sp,
        letterSpacing = (16 * -0.02).sp,
    ),
    body2Normal = PretendardStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = (15 * 1.5).sp,
        letterSpacing = (15 * -0.02).sp,
    ),
    body2Reading = PretendardStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = (15 * 1.6).sp,
        letterSpacing = (15 * -0.02).sp,
    ),
    label1Normal = PretendardStyle.copy(
        fontWeight = FontWeight.Bold,
        fontSize = 13.sp,
        lineHeight = (13 * 1.3).sp,
        letterSpacing = (13 * -0.02).sp,
    ),
    label1Reading = PretendardStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 13.sp,
        lineHeight = (13 * 1.5).sp,
        letterSpacing = (13 * -0.02).sp,
    ),
    caption1 = PretendardStyle.copy(
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = (12 * 1.3).sp,
        letterSpacing = (12 * -0.02).sp,
    ),
)

@Immutable
data class TnTTypography(
    val h1: TextStyle,
    val h2: TextStyle,
    val h3: TextStyle,
    val h4: TextStyle,
    val body1Normal: TextStyle,
    val body1Reading: TextStyle,
    val body2Normal: TextStyle,
    val body2Reading: TextStyle,
    val label1Normal: TextStyle,
    val label1Reading: TextStyle,
    val caption1: TextStyle,
)

val LocalTypography = staticCompositionLocalOf {
    TnTTypography(
        h1 = PretendardStyle,
        h2 = PretendardStyle,
        h3 = PretendardStyle,
        h4 = PretendardStyle,
        body1Normal = PretendardStyle,
        body1Reading = PretendardStyle,
        body2Normal = PretendardStyle,
        body2Reading = PretendardStyle,
        label1Normal = PretendardStyle,
        label1Reading = PretendardStyle,
        caption1 = PretendardStyle,
    )
}

