package co.kr.tnt.signup.common.role

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.kr.tnt.core.designsystem.R
import co.kr.tnt.designsystem.component.button.TnTBottomButton
import co.kr.tnt.designsystem.component.button.TnTTextButton
import co.kr.tnt.designsystem.component.button.model.ButtonSize
import co.kr.tnt.designsystem.component.button.model.ButtonType
import co.kr.tnt.designsystem.theme.TnTTheme

@Composable
fun RoleSelectionScreen(
    modifier: Modifier = Modifier,
) {
    var selectedRole by remember { mutableStateOf("트레이너") }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.padding(start = 24.dp, top = 60.dp)) {
            Text(
                text = stringResource(R.string.signup_select_role_title),
                color = TnTTheme.colors.neutralColors.Neutral950,
                style = TnTTheme.typography.h2,
            )

            Spacer(modifier = Modifier.padding(top = 12.dp))

            Text(
                text = stringResource(R.string.signup_select_role_subtitle),
                color = TnTTheme.colors.neutralColors.Neutral500,
                style = TnTTheme.typography.body1Medium,
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Image(
            painter = painterResource(R.drawable.img_select_role),
            contentDescription = null,
            modifier = Modifier.align(Alignment.CenterHorizontally),
        )

        Spacer(modifier = Modifier.weight(1f))

        // TODO 선택한 버튼 정보 저장
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 20.dp),
        ) {
            TnTTextButton(
                text = "트레이너",
                modifier = Modifier.weight(1f),
                size = ButtonSize.Large,
                type = if (selectedRole == "트레이너") ButtonType.RedOutline else ButtonType.GrayOutline,
                onClick = { selectedRole = "트레이너" },
            )

            TnTTextButton(
                text = "트레이니",
                modifier = Modifier.weight(1f),
                size = ButtonSize.Large,
                type = if (selectedRole == "트레이니") ButtonType.RedOutline else ButtonType.GrayOutline,
                onClick = { selectedRole = "트레이니" },
            )
        }

        Spacer(modifier = Modifier.padding(top = 54.dp))

        // TODO 클릭 시 이름 입력 화면으로 이동
        TnTBottomButton(
            text = "다음",
            enabled = true,
            onClick = {},
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun RoleScreenPreview() {
    TnTTheme {
        RoleSelectionScreen(modifier = Modifier.fillMaxSize())
    }
}
