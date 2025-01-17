package co.kr.tnt.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
@Suppress("UnusedParameter")
internal fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel(),
) {
    LoginScreen()
}

@Composable
fun LoginScreen() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(
            text = "login",
            modifier = Modifier.padding(innerPadding),
        )
    }
}
