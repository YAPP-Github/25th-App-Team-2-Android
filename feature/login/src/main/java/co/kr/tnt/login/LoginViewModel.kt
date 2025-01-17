package co.kr.tnt.login

import co.kr.tnt.login.LoginContract.LoginSideEffect
import co.kr.tnt.login.LoginContract.LoginUiEvent
import co.kr.tnt.login.LoginContract.LoginUiState
import co.kr.tnt.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor() : BaseViewModel<LoginUiState, LoginUiEvent, LoginSideEffect>(
    LoginUiState,
) {
    override suspend fun handleEvent(event: LoginUiEvent) {
        // TODO
    }
}
