package co.kr.tnt.designsystem.component.button.model

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.kr.tnt.designsystem.theme.TnTTheme

enum class ButtonSize(
    val height: Dp,
    val contentPadding: PaddingValues,
    val cornerRadius: Dp,
) {
    XLarge(
        height = 64.dp,
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp),
        cornerRadius = 16.dp,
    ),
    Large(
        height = 56.dp,
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 16.dp),
        cornerRadius = 16.dp,
    ),
    Medium(
        height = 50.dp,
        contentPadding = PaddingValues(horizontal = 20.dp, vertical = 12.dp),
        cornerRadius = 12.dp,
    ),
    Small(
        height = 32.dp,
        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 7.dp),
        cornerRadius = 8.dp,
    ),
    XSmall(
        height = 24.dp,
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 3.dp),
        cornerRadius = 6.dp,
    );

    @Composable
    fun textStyle(): TextStyle {
        return when (this) {
            XLarge -> TnTTheme.typography.body1SemiBold
            Large -> TnTTheme.typography.body2Bold
            Medium -> TnTTheme.typography.body1Medium
            Small, XSmall -> TnTTheme.typography.label2Medium
        }
    }
}
