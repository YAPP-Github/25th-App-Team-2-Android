package co.kr.tnt.signup.common

import co.kr.tnt.ui.base.UiEvent
import co.kr.tnt.ui.base.UiSideEffect
import co.kr.tnt.ui.base.UiState

internal class SignUpContract {
    data class SignUpUiState(
        val currentPage: SignUpPage = SignUpPage.TraineeProfileSetup,
    ) : UiState

    sealed interface SignUpUiEvent : UiEvent {
        data object NavigateToConnect : SignUpUiEvent
        data class PageChange(val page: SignUpPage) : SignUpUiEvent
    }

    sealed interface SignUpSideEffect : UiSideEffect {
        data object NavigateToConnect : SignUpSideEffect
    }
}
