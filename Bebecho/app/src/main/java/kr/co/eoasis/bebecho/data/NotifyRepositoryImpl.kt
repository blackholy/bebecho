package kr.co.eoasis.bebecho.data

import kotlinx.coroutines.flow.Flow
import kr.co.eoasis.bebecho.data.network.ApiService
import kr.co.eoasis.bebecho.data.network.dto.PostNotifyDto
import kr.co.eoasis.bebecho.data.network.dto.PostNotifyDto2
import kr.co.eoasis.bebecho.data.network.dto.PostNotifySeeMoreDto
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

class NotifyRepositoryImpl @Inject constructor(private val service: ApiService) : NotifyRepository {
    override suspend fun findNotifyById(id: String) : Response<PostNotifySeeMoreDto> {
     return service.getPostNotifyData(id)
    }

    override suspend fun findNotifyListByIds(id: Int, bqId: Int): Response<PostNotifyDto2> {
        return service.getPostNotifyListData(id, bqId)
    }
}
