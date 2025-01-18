package co.kr.tnt.connect

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.designsystem.component.TnTLabeledTextFieldForCode
import co.kr.tnt.designsystem.component.TnTTopBarNoBackButton
import co.kr.tnt.designsystem.component.button.TnTBottomButton
import co.kr.tnt.designsystem.component.button.TnTTextButton
import co.kr.tnt.designsystem.component.button.model.ButtonSize
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.feature.connect.R

@Composable
fun TraineeConnectCodeScreen(
    onSkipClick: () -> Unit,
    onNextClick: () -> Unit,
) {
    val maxLength = 8
    var text by remember { mutableStateOf("") }
    var isWarning by remember { mutableStateOf(false) }

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
                            onSkipClick()
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
                    text = stringResource(R.string.type_invite_code_from_trainer),
                    color = TnTTheme.colors.neutralColors.Neutral950,
                    style = TnTTheme.typography.h2,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
                Spacer(Modifier.padding(top = 48.dp))
                TnTLabeledTextFieldForCode(
                    title = stringResource(R.string.my_invite_code),
                    value = text,
                    onValueChange = { text = it },
                    placeholder = stringResource(R.string.please_type_code),
                    showWarning = isWarning,
                    isSingleLine = true,
                    isRequired = false,
                    warningMessage = "인증되었어요",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    trailingComponent = {
                        TnTTextButton(
                            text = "인증하기",
                            size = ButtonSize.Small,
                            onClick = { isWarning = text.length >= 6 },
                        )
                    },
                )
            }
            TnTBottomButton(
                text = stringResource(R.string.complete),
                enabled = text.isNotBlank() && isWarning,
                onClick = onNextClick,
                modifier = Modifier.align(Alignment.BottomCenter),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TraineeConnectCodeScreenPreview() {
    TnTTheme {
        TraineeConnectCodeScreen(
            onSkipClick = {},
            onNextClick = {},
        )
    }
}
