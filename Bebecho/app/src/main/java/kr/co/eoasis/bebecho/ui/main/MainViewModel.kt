package kr.co.eoasis.bebecho.ui.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kr.co.eoasis.bebecho.data.repository.UserRepository
import javax.inject.Inject

data class MainUiState(
    val isLoading: Boolean = false,
    val tabPosition: Int = 0,
    val userNm:String="",
    val userIdx:Int =0,
    val userEmail:String="",
    val userId:String="",


)

@HiltViewModel
class MainViewModel @Inject constructor( private val userRepository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()
    val userData = userRepository.userData
    fun setTabPosition(position: Int) {
        _uiState.value = _uiState.value.copy(tabPosition = position)
    }



    fun updateUserNm(userNm : String){
        _uiState.update {
            it.copy(userNm = userNm)
        }
    }
    fun updateUserId(userId : String){
        _uiState.update {
            it.copy(userId = userId)
        }
    }
    fun updateUserIdx(userIdx : Int){
        _uiState.update {
            it.copy(userIdx = userIdx)
        }
    }

    fun updateUserEmail(userEmail : String){
        _uiState.update {
            it.copy(userEmail = userEmail)
        }
    }



}