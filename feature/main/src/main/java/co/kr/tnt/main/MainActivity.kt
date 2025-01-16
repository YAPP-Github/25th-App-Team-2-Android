package co.kr.tnt.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.main.ui.TnTApp
import co.kr.tnt.main.ui.rememberTnTAppState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appState = rememberTnTAppState()

            TnTTheme {
                TnTApp(appState)
            }
        }
    }
}
