package co.kr.tnt.signup.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import co.kr.tnt.designsystem.theme.TnTTheme

@Composable
internal fun SignUpRoute(
    @Suppress("UnusedParameter")
    viewModel: SignUpViewModel = hiltViewModel(),
) {
    SignUpScreen(
        modifier = Modifier.padding(20.dp),
    )
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
) {
    Row(modifier = modifier.fillMaxSize()) {
        Text("sign up")
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpScreenPreview() {
    TnTTheme {
        SignUpScreen(
            modifier = Modifier.padding(20.dp),
        )
    }
}
