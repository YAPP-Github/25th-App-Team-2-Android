package co.kr.tnt.signup.common.role.model

import co.kr.tnt.core.designsystem.R

sealed class RoleState(
    val text: String,
    val roleImageResId: Int,
) {
    data object Trainer : RoleState(
        text = "트레이너",
        roleImageResId = R.drawable.img_select_role_trainer,
    )

    data object Trainee : RoleState(
        text = "트레이니",
        roleImageResId = R.drawable.img_select_role_trainee,
    )
}
