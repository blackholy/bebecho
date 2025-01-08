package kr.co.eoasis.bebecho.ui.login.singup

import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import javax.inject.Inject


data class SignUpUiState(
    val isLoading: Boolean = false,
    val isEnabled: Boolean = false,
    val id:String = "",
    val name:String = "",
    val password:String = "",
    val birth : TextFieldValue = TextFieldValue(""),
    val email : String = ""
)

@HiltViewModel
class SignUpViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(SignUpUiState())
    val uiState: StateFlow<SignUpUiState> = _uiState.asStateFlow()

    fun updateId(id : String){
        _uiState.update {
            it.copy(id = id)
        }
    }
    fun updateName(name : String){
        _uiState.update {
            it.copy(name = name)
        }
    }
    fun updatePassword(password : String){
        _uiState.update {
            it.copy(password = password)
        }
    }
    fun updateBirth(birth : TextFieldValue){
        _uiState.update {
            it.copy(birth = birth)
        }
    }
    fun updateEmail(email : String){
        _uiState.update {
            it.copy(email = email)
        }
    }

}