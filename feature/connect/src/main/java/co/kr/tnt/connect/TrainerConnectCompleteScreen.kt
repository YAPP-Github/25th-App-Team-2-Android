package co.kr.tnt.connect

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.designsystem.component.button.TnTBottomButton
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.feature.connect.R

@Composable
fun TrainerConnectCompleteScreen(
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    BackHandler { onBackClick() }

    val name = "김회원"

    Scaffold { innerPadding ->
        Image(
            painter = painterResource(R.drawable.img_connection_complete_background_3x),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            Column(Modifier.fillMaxSize()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(36.dp),
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Spacer(Modifier.weight(1f))
                    Text(
                        text = stringResource(R.string.connect_with_trainee, name),
                        color = TnTTheme.colors.commonColors.Common0,
                        style = TnTTheme.typography.h1,
                        modifier = Modifier.padding(horizontal = 24.dp),
                        textAlign = TextAlign.Center,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        ProfileSection(
                            name = "김회원",
                            image = co.kr.tnt.core.designsystem.R.drawable.img_default_profile_trainee
                        )
                        Spacer(Modifier.padding(16.dp))
                        ProfileSection(
                            name = "김피티",
                            image = co.kr.tnt.core.designsystem.R.drawable.img_default_profile_trainer
                        )
                    }
                    Image(
                        painter = painterResource(R.drawable.img_boom_3x),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.width(320.dp),
                    )
                    Spacer(Modifier.weight(1f))
                }
            }
            TnTBottomButton(
                text = stringResource(R.string.next),
                onClick = onNextClick,
                modifier = Modifier.align(Alignment.BottomCenter),
            )
        }
    }
}

@Composable
private fun ProfileSection(
    name: String,
    image: Int,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(100.dp),
        )
        Text(
            text = name,
            color = TnTTheme.colors.neutralColors.Neutral300,
            style = TnTTheme.typography.body2Medium,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun TrainerConnectCompleteScreenPreview() {
    TnTTheme {
        TrainerConnectCompleteScreen(
            onNextClick = {},
            onBackClick = {},
        )
    }
}
