package co.kr.tnt.signup.trainee

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.core.designsystem.R
import co.kr.tnt.designsystem.component.TnTTopBar
import co.kr.tnt.designsystem.component.button.TnTBottomButton
import co.kr.tnt.designsystem.component.button.TnTTextButton
import co.kr.tnt.designsystem.component.button.model.ButtonSize
import co.kr.tnt.designsystem.component.button.model.ButtonType
import co.kr.tnt.designsystem.theme.TnTTheme
import co.kr.tnt.signup.trainee.component.StepProgressHeader

@Composable
fun TraineePTPurposeScreen() {
    // Pair로 관리
    val purposeItems = listOf(
        R.string.signup_pt_purpose_loss_weight to R.string.signup_pt_purpose_strength,
        R.string.signup_pt_purpose_health_care to R.string.signup_pt_purpose_flexibility,
        R.string.signup_pt_purpose_body_profile to R.string.signup_pt_purpose_posture_correction,
    )

    // TODO 리소스 id값 텍스트로 전환해 넘겨주기
    val selectedPurposes = remember { mutableStateOf(setOf<Int>()) }

    // 선택된 값 확인용
    val context = LocalContext.current
    val selectedTexts = selectedPurposes.value.map { context.getString(it) }

    Scaffold(
        // TODO 버튼 클릭 시 트레이니 기본 정보 입력 화면으로 이동
        topBar = { TnTTopBar(onBackClick = {}) },
        containerColor = TnTTheme.colors.commonColors.Common0,
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Column(modifier = Modifier.fillMaxSize()) {
                StepProgressHeader(
                    currentStep = 3,
                    totalSteps = 4,
                    title = stringResource(R.string.signup_pt_purpose_title),
                    subTitle = stringResource(R.string.signup_pt_purpose_subtitle),
                )
                Spacer(Modifier.padding(top = 32.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(horizontal = 20.dp),
                ) {
                    // 한 행에 2개씩
                    purposeItems.forEach { (first, second) ->
                        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                            PurposeButton(
                                textResId = first,
                                isSelected = first in selectedPurposes.value,
                                onClick = {
                                    toggleSelection(selectedPurposes, first)
                                },
                                modifier = Modifier.weight(1f),
                            )
                            PurposeButton(
                                textResId = second,
                                isSelected = second in selectedPurposes.value,
                                onClick = {
                                    toggleSelection(selectedPurposes, second)
                                },
                                modifier = Modifier.weight(1f),
                            )
                        }
                    }
                }
            }
            // TODO PT 주의사항 입력 화면으로 이동
            TnTBottomButton(
                text = stringResource(R.string.next),
                onClick = { Log.d("check", "선택된 값들\n$selectedTexts") },
                enabled = selectedPurposes.value.isNotEmpty(),
                modifier = Modifier.align(Alignment.BottomCenter),
            )
        }
    }
}

@Composable
fun PurposeButton(
    @StringRes textResId: Int,
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    TnTTextButton(
        text = stringResource(textResId),
        modifier = modifier,
        size = ButtonSize.XLarge,
        type = if (isSelected) ButtonType.RedOutline else ButtonType.GrayOutline,
        onClick = onClick,
    )
}

// 선택된 값 업데이트
private fun toggleSelection(selectedPurposes: MutableState<Set<Int>>, purposeId: Int) {
    selectedPurposes.value = if (purposeId in selectedPurposes.value) {
        // 선택 해제
        selectedPurposes.value - purposeId
    } else {
        // 선택 추가
        selectedPurposes.value + purposeId
    }
}

@Preview(showBackground = true)
@Composable
private fun TraineePTPurposeScreenPreview() {
    TnTTheme {
        TraineePTPurposeScreen()
    }
}
