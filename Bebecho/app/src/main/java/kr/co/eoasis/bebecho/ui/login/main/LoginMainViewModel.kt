package kr.co.eoasis.bebecho.ui.login.main

import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kr.co.eoasis.bebecho.data.repository.UserRepository
import kr.co.eoasis.bebecho.ui.main.MainViewModel
import javax.inject.Inject

data class LoginMainUiState(
    val isLoading: Boolean = false,
    val isEnabled: Boolean = false,
    val id: String = "",
    val password:String = "",
    val isLoggedIn: Boolean = false,  // 추가: 로그인 성공 여부
    )

@HiltViewModel
class LoginMainViewModel @Inject constructor( private val userRepository: UserRepository) : ViewModel() {


    private val _uiState = MutableStateFlow(LoginMainUiState())
     // MainViewModel 주입
    val uiState: StateFlow<LoginMainUiState> = _uiState.asStateFlow()

    fun updateId(id : String){
        _uiState.update {
            it.copy(id = id)
        }
    }
    fun updatePassword(password : String){
        _uiState.update {
            it.copy(password = password)
        }
    }

    fun LoginChek(): Boolean {
        var isLogin : Boolean = false
        isLogin=true //로그인 로직 추가해야됨 우선 성공했다고 가정
        if(isLogin){

        userRepository.updateUserData(
            userId = uiState.value.id,
            userNm = "김재영",
            userIdx=0,
            userEmail="",
        )
      //   navigationAction.navigateToMain() // 메인 페이지로 이동

          //  _uiState.update { it.copy(isLoggedIn = true) }
            _uiState.update { it.copy(isLoggedIn = true) }

        }
        else{
            //로그인 실패 알림 띄우기
        }
        return isLogin
    }


}