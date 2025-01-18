package co.kr.tnt.signup.common

import co.kr.tnt.signup.common.SignUpContract.SignUpSideEffect
import co.kr.tnt.signup.common.SignUpContract.SignUpUiEvent
import co.kr.tnt.signup.common.SignUpContract.SignUpUiEvent.NavigateToConnect
import co.kr.tnt.signup.common.SignUpContract.SignUpUiState
import co.kr.tnt.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class SignUpViewModel @Inject constructor() :
    BaseViewModel<SignUpUiState, SignUpUiEvent, SignUpSideEffect>(
        SignUpUiState()
    ) {
    override suspend fun handleEvent(event: SignUpUiEvent) {
        when (event) {
            NavigateToConnect -> sendEffect(SignUpSideEffect.NavigateToConnect)
            is SignUpUiEvent.PageChange -> updatePage(event.page)
        }
    }

    private fun updatePage(page: SignUpPage) {
        updateState { copy(currentPage = page) }
    }
}
