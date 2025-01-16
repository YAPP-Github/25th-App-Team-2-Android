package co.kr.tnt.signup.trainee

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import co.kr.tnt.core.designsystem.R
import co.kr.tnt.designsystem.component.TnTLabeledTextField
import co.kr.tnt.designsystem.component.TnTTopBar
import co.kr.tnt.designsystem.component.button.TnTBottomButton
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.signup.common.component.ProfileImageSection
import co.kr.tnt.signup.trainee.component.StepProgressHeader

@Composable
fun SetTraineeProfileScreen(
    modifier: Modifier = Modifier,
) {
    // TODO 상태 관리 따로 빼기
    val maxLength = 15
    var text by remember { mutableStateOf("") }
    val warningState by remember { derivedStateOf { text.length > maxLength } }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(TnTTheme.colors.commonColors.Common0)
            .navigationBarsPadding(),
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .imePadding()
                .verticalScroll(rememberScrollState()),
        ) {
            // TODO 버튼 클릭 시 트레이너/트레이니 선택 화면으로 이동
            TnTTopBar(onBackClick = {})
            StepProgressHeader(
                currentStep = 1,
                totalSteps = 4,
                title = stringResource(R.string.signup_set_name_title),
            )
            Spacer(Modifier.padding(top = 48.dp))
            ProfileImageSection(
                Modifier.fillMaxWidth(),
                defaultImage = R.drawable.img_default_profile_trainee,
                onImageSelected = { },
            )
            Spacer(Modifier.padding(top = 60.dp))
            TnTLabeledTextField(
                title = stringResource(R.string.name),
                value = text,
                onValueChange = { newValue ->
                    val filteredText = validateInput(newValue)
                    text = filteredText
                },
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 20.dp),
                placeholder = stringResource(R.string.signup_set_name_placeholder),
                maxLength = maxLength,
                isSingleLine = true,
                showWarning = warningState,
                isRequired = true,
                warningMessage = "$maxLength" + stringResource(R.string.signup_warning_text_length),
            )
        }
        // TODO 트레이니 기본 정보 입력 화면으로 이동
        TnTBottomButton(
            text = stringResource(R.string.next),
            enabled = text.isNotBlank() && !warningState,
            onClick = { },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(top = 20.dp),
        )
    }
}

/**
 * 입력 값을 검사해 한글/영어/공백만 허용하고 특수문자는 제거
 */
private fun validateInput(input: String): String {
    return input.filter { it.isLetter() || it.isWhitespace() }
}

@Preview(showBackground = true)
@Composable
private fun SetTraineeProfilePreview() {
    TnTTheme {
        SetTraineeProfileScreen(modifier = Modifier.fillMaxSize())
    }
}
