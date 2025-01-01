package co.kr.tnt.data.model.tnt.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TnTResponse(
    @SerialName("id")
    val id: String,
)
