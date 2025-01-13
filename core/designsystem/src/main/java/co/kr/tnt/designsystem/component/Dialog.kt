package co.kr.tnt.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import co.kr.tnt.designsystem.component.button.TnTTextButton
import co.kr.tnt.designsystem.component.button.model.ButtonSize
import co.kr.tnt.designsystem.component.button.model.ButtonType
import co.kr.tnt.designsystem.theme.TnTTheme

@Composable
fun TnTPopupDialog(
    title: String,
    content: String,
    leftButtonText: String,
    rightButtonText: String,
    onLeftButtonClick: () -> Unit,
    onRightButtonClick: () -> Unit,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Dialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            colors = cardColors().copy(TnTTheme.colors.commonColors.Common0),
            modifier = modifier
                .wrapContentSize()
                .padding(horizontal = 32.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp),
            ) {
                Text(
                    text = title,
                    style = TnTTheme.typography.h4.copy(
                        textAlign = TextAlign.Center,
                    ),
                    color = TnTTheme.colors.neutralColors.Neutral900,
                    modifier = Modifier.padding(top = 20.dp),
                )

                Text(
                    text = content,
                    style = TnTTheme.typography.body2Medium.copy(
                        textAlign = TextAlign.Center,
                    ),
                    color = TnTTheme.colors.neutralColors.Neutral500,
                    modifier = Modifier.padding(top = 10.dp),
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.padding(top = 20.dp),
                ) {
                    TnTTextButton(
                        size = ButtonSize.Medium,
                        type = ButtonType.Gray,
                        text = leftButtonText,
                        onClick = onLeftButtonClick,
                        modifier = Modifier.weight(1f),
                    )

                    TnTTextButton(
                        size = ButtonSize.Medium,
                        type = ButtonType.Primary,
                        text = rightButtonText,
                        onClick = onRightButtonClick,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun TnTPopupDialogPreview() {
    TnTTheme {
        TnTPopupDialog(
            title = "사진을 받으려면 동의가 필요해요\n동의를 받으세요",
            content = "트레이너가 회원님을 구분하는 데 사용돼요",
            leftButtonText = "취소",
            rightButtonText = "확인",
            onLeftButtonClick = { },
            onRightButtonClick = { },
            onDismiss = { },
        )
    }
}
