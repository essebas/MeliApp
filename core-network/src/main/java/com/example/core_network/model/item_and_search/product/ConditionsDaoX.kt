package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConditionsDaoX(
    @SerialName("context_restrictions")
    val contextRestrictions: List<String>,
    @SerialName("eligible")
    val eligible: Boolean,
    /*@SerialName("end_time")
    val endTime: AnyDao?,
    @SerialName("start_time")
    val startTime: AnyDao?*/
)