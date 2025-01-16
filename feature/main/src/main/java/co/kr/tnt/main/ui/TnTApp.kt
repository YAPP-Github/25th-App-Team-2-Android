package co.kr.tnt.main.ui

import androidx.compose.runtime.Composable

@Composable
fun TnTApp(
    appState: TnTAppState,
) {
    TnTNavHost(
        appState = appState,
    )
}
