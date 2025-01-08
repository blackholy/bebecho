package kr.co.eoasis.bebecho.data.network.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PostNotifySeeMoreDto(
    @Json(name = "val1") val id : Int,
    @Json(name = "val2")val title: String,
    @Json(name = "val3")val content: String,
)
