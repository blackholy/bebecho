package kr.co.eoasis.bebecho.data

import kotlinx.coroutines.flow.Flow
import kr.co.eoasis.bebecho.data.network.dto.PostNotifyDto
import kr.co.eoasis.bebecho.data.network.dto.PostNotifyDto2
import kr.co.eoasis.bebecho.data.network.dto.PostNotifySeeMoreDto
import retrofit2.Response

interface NotifyRepository {
    suspend fun findNotifyById(id:String) : Response<PostNotifySeeMoreDto>
    suspend fun findNotifyListByIds(id:Int, bqId:Int): Response<PostNotifyDto2>
}
