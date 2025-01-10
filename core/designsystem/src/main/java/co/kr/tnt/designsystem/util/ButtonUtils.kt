package co.kr.tnt.designsystem.util

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.kr.tnt.designsystem.theme.TnTTheme

enum class ButtonSize {
    XLarge,
    Large,
    Medium,
    Small,
    XSmall,
}

enum class ButtonType {
    Primary,
    Gray,
    GrayOutline,
    RedOutline,
}

sealed class IconPosition {
    data class Leading(val icon: @Composable () -> Unit) : IconPosition()
    data class Trailing(val icon: @Composable () -> Unit) : IconPosition()
}

data class ButtonConfig(
    val height: Dp,
    val contentPadding: PaddingValues,
    val textStyle: TextStyle,
    val cornerRadius: Dp,
    val colors: ButtonColors,
    val stroke: Dp,
    val borderColor: Color,
)

@Composable
fun getButtonConfig(size: ButtonSize, variant: ButtonType, enabled: Boolean): ButtonConfig {
    val height = when (size) {
        ButtonSize.XLarge -> 64.dp
        ButtonSize.Large -> 56.dp
        ButtonSize.Medium -> 50.dp
        ButtonSize.Small -> 32.dp
        ButtonSize.XSmall -> 24.dp
    }

    val contentPadding = when (size) {
        ButtonSize.XLarge -> PaddingValues(horizontal = 20.dp, vertical = 20.dp)
        ButtonSize.Large -> PaddingValues(horizontal = 20.dp, vertical = 16.dp)
        ButtonSize.Medium -> PaddingValues(horizontal = 20.dp, vertical = 12.dp)
        ButtonSize.Small -> PaddingValues(horizontal = 12.dp, vertical = 7.dp)
        ButtonSize.XSmall -> PaddingValues(horizontal = 8.dp, vertical = 3.dp)
    }

    val textStyle = when (size) {
        ButtonSize.XLarge -> TnTTheme.typography.body1SemiBold
        ButtonSize.Large -> TnTTheme.typography.body2Bold
        ButtonSize.Medium -> TnTTheme.typography.body1Medium
        ButtonSize.Small, ButtonSize.XSmall -> TnTTheme.typography.label2Medium
    }

    val cornerRadius = when (size) {
        ButtonSize.XLarge, ButtonSize.Large -> 16.dp
        ButtonSize.Medium -> 12.dp
        ButtonSize.Small -> 8.dp
        ButtonSize.XSmall -> 6.dp
    }

    val colors = when (variant) {
        ButtonType.Primary -> ButtonDefaults.buttonColors(
            containerColor = TnTTheme.colors.neutralColors.Neutral900,
            contentColor = TnTTheme.colors.neutralColors.Neutral50,
            disabledContainerColor = TnTTheme.colors.neutralColors.Neutral200,
            disabledContentColor = TnTTheme.colors.neutralColors.Neutral50,
        )

        ButtonType.Gray -> ButtonDefaults.buttonColors(
            containerColor = TnTTheme.colors.neutralColors.Neutral100,
            contentColor = TnTTheme.colors.neutralColors.Neutral500,
            disabledContainerColor = TnTTheme.colors.neutralColors.Neutral200,
            disabledContentColor = TnTTheme.colors.neutralColors.Neutral50,
        )

        ButtonType.GrayOutline -> ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = TnTTheme.colors.neutralColors.Neutral500,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = TnTTheme.colors.neutralColors.Neutral300,
        )

        ButtonType.RedOutline -> ButtonDefaults.buttonColors(
            containerColor = TnTTheme.colors.mainColors.Red50,
            contentColor = TnTTheme.colors.mainColors.Red600,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = TnTTheme.colors.neutralColors.Neutral300,
        )
    }

    val stroke = when (variant) {
        ButtonType.Primary -> 0.dp
        ButtonType.Gray -> 0.dp
        ButtonType.GrayOutline -> if (size == ButtonSize.XSmall) 1.5.dp else 1.dp
        ButtonType.RedOutline -> if (enabled) 1.5.dp else 1.dp
    }

    val borderColor = when (variant) {
        ButtonType.Primary -> Color.Transparent
        ButtonType.Gray -> Color.Transparent
        ButtonType.GrayOutline -> TnTTheme.colors.neutralColors.Neutral300
        ButtonType.RedOutline -> if (enabled) {
            TnTTheme.colors.mainColors.Red400
        } else {
            TnTTheme.colors.neutralColors.Neutral300
        }
    }

    return ButtonConfig(
        height = height,
        contentPadding = contentPadding,
        textStyle = textStyle,
        cornerRadius = cornerRadius,
        colors = colors,
        stroke = stroke,
        borderColor = borderColor,
    )
}
