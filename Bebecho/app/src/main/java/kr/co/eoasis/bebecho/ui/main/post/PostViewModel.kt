package kr.co.eoasis.bebecho.ui.main.post

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kr.co.eoasis.bebecho.data.NotifyRepository
import kr.co.eoasis.bebecho.data.network.dto.PostNotifyDto
//import kr.co.eoasis.bebecho.data.NotifyRepository
import kr.co.eoasis.bebecho.ui.main.History.HistoryUiState
import kr.co.eoasis.bebecho.util.State
import org.jetbrains.annotations.Async
import javax.inject.Inject

data class PostUiState(
    val isLoading: Boolean = false,
    val tabPosition: Int = 0,
    val searchText: String = "",
    val startDate: String = "2024-12-9",
    val endDate: String = "2024-12-10",
    val notifyPostList: List<NotifyPost> = listOf()
)


@HiltViewModel
class PostViewModel @Inject constructor(/*private val repository: NotifyRepository*/): ViewModel(){
    private val _uiState = MutableStateFlow(PostUiState())
    val uiState: StateFlow<PostUiState> = _uiState

   /* init {
        // 초기 데이터 설정
        viewModelScope.launch {
            try{
                val response = repository.findNotifyListByIds(id = 1, bqId = 20)
                if(response.isSuccessful){
                    _uiState.value = _uiState.value.copy(notifyPostList = response.body()!!.list.map { NotifyPost(it.id.toInt(), it.title, it.content, it.date) })
                }else{
                    Log.e(TAG, "findListError: ${response.message()}", )
                }
            }catch (e:Exception) {
                Log.e(TAG, "findListError: ${e.message}",)
            }

        }
    }*/

    fun updateTabPosition(position: Int){
        _uiState.value = _uiState.value.copy(tabPosition = position)
    }
    fun updateSearchText(text: String){
        _uiState.value = _uiState.value.copy(searchText = text)
    }

    fun produceNotifyList(state : State<List<PostNotifyDto>>)=
        when(state){
            State.Loading ->{
                PostUiState(isLoading = true)
            }
            is State.Error ->{
                PostUiState(isLoading = false)
            }
            is State.Success -> {
                PostUiState(isLoading = false, notifyPostList = state.data.map { NotifyPost(it.id.toInt(), it.title, it.content, it.date) })
            }
        }
    }



data class NotifyPost(
    val id: Int,
    val title: String,
    val content:String,
    val date: String,
)