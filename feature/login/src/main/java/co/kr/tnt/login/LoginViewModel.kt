package co.kr.tnt.login

import co.kr.tnt.login.LoginContract.LoginSideEffect
import co.kr.tnt.login.LoginContract.LoginUiEvent
import co.kr.tnt.login.LoginContract.LoginUiState
import co.kr.tnt.login.model.TermState
import co.kr.tnt.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
internal class LoginViewModel @Inject constructor() : BaseViewModel<LoginUiState, LoginUiEvent, LoginSideEffect>(
    LoginUiState(),
) {
    override suspend fun handleEvent(event: LoginUiEvent) {
        when (event) {
            LoginUiEvent.OnClickKakaoLogin -> sendEffect(LoginSideEffect.ShowTermBottomSheet)
            LoginUiEvent.OnCheckAllTermAgree -> checkAllTerms()
            is LoginUiEvent.OnCheckTerm -> checkTerm(event.termState)
            is LoginUiEvent.OnClickTermLink -> TODO()
            LoginUiEvent.OnClickNext -> TODO()
        }
    }

    private fun checkAllTerms() {
        updateState {
            copy(
                terms = terms.keys.associateWith {
                    !isAllTermChecked()
                },
            )
        }
    }

    private fun checkTerm(termState: TermState) {
        updateState {
            copy(
                terms = terms.toMutableMap()
                    .also { terms -> terms[termState] = !(terms[termState] ?: false) }
                    .toMap(),
            )
        }
    }
}
