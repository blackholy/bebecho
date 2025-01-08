package kr.co.eoasis.bebecho.data.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostNotifyDto2(
    val status: String,
    val list: List<PostNotifyDto>
)