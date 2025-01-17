package co.kr.tnt.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.feature.login.R

@Composable
@Suppress("UnusedParameter")
internal fun LoginRoute(
    viewModel: LoginViewModel = hiltViewModel(),
) {
    LoginScreen()
}

@Composable
private fun LoginScreen() {
    Scaffold(containerColor = TnTTheme.colors.commonColors.Common0) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 28.dp),
                    text = stringResource(R.string.nice_to_meet_you),
                    color = TnTTheme.colors.neutralColors.Neutral500,
                    style = TnTTheme.typography.body1Medium,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 28.dp),
                    text = stringResource(R.string.trainer_trainee_chemistry_boom),
                    color = TnTTheme.colors.neutralColors.Neutral950,
                    style = TnTTheme.typography.h1,
                )
                Spacer(modifier = Modifier.height(48.dp))
                Image(
                    painter = painterResource(id = R.drawable.img_trainer_and_trainee),
                    contentDescription = "trainer and trainee",
                    modifier = Modifier.size(310.dp),
                )
                Spacer(modifier = Modifier.height(48.dp))
                KakaoLoginButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    onClick = {
                        // TODO 약관 확인 바텀시트 출력
                    },
                )
            }
        }
    }
}

@Composable
private fun KakaoLoginButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFDE500),
            contentColor = TnTTheme.colors.neutralColors.Neutral900,
        ),
        contentPadding = PaddingValues(
            vertical = 16.dp,
            horizontal = 20.dp,
        ),
        shape = RoundedCornerShape(16.dp),
        onClick = onClick,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_kakao),
                contentDescription = "Kakao login",
            )
            Text(
                text = stringResource(R.string.continue_with_kakao),
                style = TnTTheme.typography.body1Medium,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoginScreenPreview() {
    TnTTheme {
        LoginScreen()
    }
}
