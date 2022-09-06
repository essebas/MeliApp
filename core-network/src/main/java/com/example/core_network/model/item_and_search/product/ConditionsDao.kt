package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConditionsDao(
    //@SerialName("context_restrictions")
    //val contextRestrictions: List<AnyDao>,
    @SerialName("eligible")
    val eligible: Boolean,
    /*@SerialName("end_time")
    val endTime: AnyDao?,
    @SerialName("start_time")
    val startTime: AnyDao?*/
)