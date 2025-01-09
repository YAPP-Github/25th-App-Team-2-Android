package co.kr.tnt.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun TnTTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalTypography provides Typography,
        LocalColors provides LocalColors.current,
    ) {
        MaterialTheme(
            content = content,
        )
    }
}

object TnTTheme {
    val colors: TnTColors
        @Composable
        get() = LocalColors.current
    val typography: TnTTypography
        @Composable
        get() = LocalTypography.current
}
