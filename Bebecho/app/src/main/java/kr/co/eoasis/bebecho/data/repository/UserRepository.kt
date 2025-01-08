package kr.co.eoasis.bebecho.data.repository

import kotlinx.coroutines.flow.StateFlow

data class UserData(
    val userId: String = "",
    val userNm: String = "",
    val userIdx: Int = 0,
    val userEmail: String = ""
)

interface UserRepository {
    val userData: StateFlow<UserData>
    
    fun updateUserData(
        userId: String,
        userNm: String,
        userIdx: Int,
        userEmail: String
    )
} 