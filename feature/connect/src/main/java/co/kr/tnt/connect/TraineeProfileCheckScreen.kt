package co.kr.tnt.connect

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.kr.tnt.designsystem.component.button.TnTBottomButton
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.feature.connect.R

@Composable
fun TraineeProfileCheckScreen(
    onNextClick: () -> Unit,
) {
    Scaffold { innerPadding ->
        Image(
            painter = painterResource(R.drawable.img_trainee_profile_3x),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TnTBottomButton(
                text = stringResource(co.kr.tnt.core.designsystem.R.string.start),
                //TODO 홈으로 이동
                onClick = onNextClick,
                modifier = Modifier.align(Alignment.BottomCenter),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TraineeProfileCheckScreenPreview() {
    TnTTheme {
        TraineeProfileCheckScreen(
            onNextClick = {},
        )
    }
}
