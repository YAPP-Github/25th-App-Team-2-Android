package co.kr.tnt.designsystem.component.button.model

import androidx.compose.runtime.Composable

sealed class IconPosition {
    data class Leading(val icon: @Composable () -> Unit) : IconPosition()
    data class Trailing(val icon: @Composable () -> Unit) : IconPosition()
}
