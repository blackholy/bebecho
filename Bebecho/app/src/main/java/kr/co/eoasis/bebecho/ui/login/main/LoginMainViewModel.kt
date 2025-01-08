package kr.co.eoasis.bebecho.ui.login.main

import androidx.lifecycle.ViewModel
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

    fun saveUserData() {
        userRepository.updateUserData(
            userId = uiState.value.id,
            userNm = "김재영",
            userIdx=0,
            userEmail="",
        )
    }
}