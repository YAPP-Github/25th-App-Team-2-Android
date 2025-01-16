package co.kr.tnt.signup.trainer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.relocation.BringIntoViewRequester
import androidx.compose.foundation.relocation.bringIntoViewRequester
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.core.designsystem.R
import co.kr.tnt.designsystem.component.TnTLabeledTextField
import co.kr.tnt.designsystem.component.TnTTopBar
import co.kr.tnt.designsystem.component.button.TnTBottomButton
import co.kr.tnt.designsystem.theme.TnTTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SetTrainerProfileScreen(
    modifier: Modifier = Modifier,
) {
    // TODO 상태 관리 따로 빼기
    val maxLength = 15
    var text by remember { mutableStateOf("") }
    var warningState by remember { mutableStateOf(false) }

    warningState = text.length > maxLength

    // 키보드가 올라올 때 TextField를 스크롤하여 보이도록 설정
    val bringIntoViewRequester = remember { BringIntoViewRequester() }
    val coroutineScope = rememberCoroutineScope()

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
            // TODO 버튼 클릭 시 트레이너/트레이니 화면으로 이동
            TnTTopBar(onBackClick = {})

            Text(
                text = stringResource(R.string.signup_set_name_title),
                modifier = Modifier.padding(start = 24.dp),
                color = TnTTheme.colors.neutralColors.Neutral950,
                style = TnTTheme.typography.h2,
            )

            Spacer(Modifier.padding(top = 48.dp))

            SetProfileImage()

            Spacer(Modifier.padding(top = 60.dp))

            TnTLabeledTextField(
                title = stringResource(R.string.name),
                value = text,
                onValueChange = { newValue ->
                    val filteredText = validateInput(newValue)
                    text = filteredText

                    // 입력 필드가 보이도록 스크롤 이동
                    coroutineScope.launch {
                        bringIntoViewRequester.bringIntoView()
                    }
                },
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(horizontal = 20.dp)
                    .bringIntoViewRequester(bringIntoViewRequester),
                placeholder = stringResource(R.string.signup_set_name_placeholder),
                maxLength = maxLength,
                showWarning = warningState,
                isRequired = true,
                warningMessage = "$maxLength" + stringResource(R.string.signup_warning_text_length),
            )
        }

        // TODO 트레이너 프로필 생성 완료 화면으로 이동
        TnTBottomButton(
            text = stringResource(R.string.next),
            enabled = text.isNotEmpty() && !warningState,
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

@Composable
private fun SetProfileImage(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentSize()
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center,
    ) {
        // TODO 유저가 선택한 이미지 보여주기
        Image(
            painter = painterResource(id = R.drawable.img_default_profile_trainer),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(131.dp)
                .clip(CircleShape),
        )

        // TODO 버튼 클릭 시 권한 확인 후 사진 선택
        IconButton(
            onClick = {},
            modifier = Modifier
                .size(28.dp)
                .align(Alignment.BottomEnd),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_edit),
                contentDescription = null,
                tint = Color.Unspecified,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SetTrainerProfilePreview() {
    TnTTheme {
        SetTrainerProfileScreen(modifier = Modifier.fillMaxSize())
    }
}
