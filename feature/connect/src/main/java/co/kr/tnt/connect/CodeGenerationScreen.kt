package co.kr.tnt.connect

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.designsystem.component.TnTTopBarNoBackButton
import co.kr.tnt.designsystem.component.button.TnTTextButton
import co.kr.tnt.designsystem.component.button.model.ButtonSize
import co.kr.tnt.designsystem.component.button.model.ButtonType
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.feature.connect.R

@Composable
fun CodeGenerationScreen(
    // 연결 완료로 이동하기 위해 Next로 설정
    onNextClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TnTTopBarNoBackButton(
                title = stringResource(R.string.connect),
                trailingComponent = {
                    Text(
                        text = stringResource(R.string.skip),
                        color = TnTTheme.colors.neutralColors.Neutral400,
                        style = TnTTheme.typography.body2Medium,
                        modifier = Modifier.clickable {
                            onNextClick()
                        },
                    )
                },
            )
        },
        containerColor = TnTTheme.colors.commonColors.Common0,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(Modifier.padding(top = 24.dp))
                Text(
                    text = stringResource(R.string.invite_trainee_with_code),
                    color = TnTTheme.colors.neutralColors.Neutral950,
                    style = TnTTheme.typography.h2,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(Modifier.padding(top = 48.dp))
                Column(Modifier.padding(horizontal = 20.dp)) {
                    Text(
                        text = stringResource(R.string.my_invite_code),
                        style = TnTTheme.typography.body1Bold,
                        color = TnTTheme.colors.neutralColors.Neutral900,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "12345678",
                                style = TnTTheme.typography.body1Medium,
                                color = TnTTheme.colors.neutralColors.Neutral600,
                                modifier = Modifier.padding(8.dp),
                            )
                            HorizontalDivider(
                                thickness = 1.dp,
                                color = TnTTheme.colors.neutralColors.Neutral200,
                                modifier = Modifier.padding(top = 4.dp)
                            )
                        }
                        Box(
                            modifier = Modifier
                                .wrapContentSize(Alignment.CenterEnd)
                                .align(Alignment.CenterVertically)
                                .padding(vertical = 4.dp),
                            content = {
                                TnTTextButton(
                                    text = stringResource(R.string.code_reissue),
                                    size = ButtonSize.Small,
                                    type = ButtonType.Gray,
                                    onClick = {},
                                )
                            },
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CodeGenerationScreenPreview() {
    TnTTheme {
        CodeGenerationScreen(
            onNextClick = {},
        )
    }
}
