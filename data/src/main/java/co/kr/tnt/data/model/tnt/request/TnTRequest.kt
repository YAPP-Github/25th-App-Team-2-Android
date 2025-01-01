package co.kr.tnt.data.model.tnt.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TnTRequest(
    @SerialName("id")
    val id: String,
)
