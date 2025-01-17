package co.kr.tnt.login

import co.kr.tnt.ui.base.UiEvent
import co.kr.tnt.ui.base.UiSideEffect
import co.kr.tnt.ui.base.UiState

internal class LoginContract {
    data object LoginUiState : UiState

    sealed interface LoginUiEvent : UiEvent {
        data object OnKakaoLoginClicked : LoginUiEvent
    }

    sealed interface LoginSideEffect : UiSideEffect {
        data object ShowTermBottomSheet : LoginSideEffect
    }
}
