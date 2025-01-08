package kr.co.eoasis.bebecho.fake

import kotlinx.coroutines.flow.MutableStateFlow
import kr.co.eoasis.bebecho.data.repository.UserData
import kr.co.eoasis.bebecho.data.repository.UserRepository

class FakeUserRepository : UserRepository {
    override val userData = MutableStateFlow(UserData())
    
    override fun updateUserData(
        userId: String,
        userNm: String,
        userIdx: Int,
        userEmail: String
    ) {
        // Preview용 더미 구현
    }
} 