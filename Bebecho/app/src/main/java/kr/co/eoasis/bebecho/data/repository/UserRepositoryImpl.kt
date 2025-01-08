package kr.co.eoasis.bebecho.data.repository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor() : UserRepository {
    private val _userData = MutableStateFlow(UserData())
    override val userData: StateFlow<UserData> = _userData

    override fun updateUserData(
        userId: String,
        userNm: String,
        userIdx: Int,
        userEmail: String
    ) {
        _userData.value = UserData(
            userId = userId,
            userNm = userNm,
            userIdx = userIdx,
            userEmail = userEmail
        )
    }
} 