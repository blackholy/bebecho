package kr.co.eoasis.bebecho.data.network

import kotlinx.coroutines.flow.Flow
import kr.co.eoasis.bebecho.data.network.dto.PostNotifyDto
import kr.co.eoasis.bebecho.data.network.dto.PostNotifyDto2
import kr.co.eoasis.bebecho.data.network.dto.PostNotifySeeMoreDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/fitcare/mobile/train/selectsample1")
    suspend fun getPostNotifyData(@Query("idx") id : String): Response<PostNotifySeeMoreDto>

    @GET("/fitcare/mobile/train/selectsample2")
    suspend fun getPostNotifyListData(@Query("idx") id : Int, @Query("bqIdx") bqId: Int): Response<PostNotifyDto2>
}
