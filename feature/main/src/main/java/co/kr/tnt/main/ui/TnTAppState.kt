package co.kr.tnt.main.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember

@Composable
fun rememberTnTAppState(): TnTAppState {
    return remember { TnTAppState() }
}

@Stable
class TnTAppState
