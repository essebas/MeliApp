package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AttributeDao(
    @SerialName("attribute_group_id")
    val attributeGroupId: String,
    @SerialName("attribute_group_name")
    val attributeGroupName: String,
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("source")
    val source: Int,
    @SerialName("value_id")
    val valueId: String,
    @SerialName("value_name")
    val valueName: String,
    @SerialName("value_struct")
    val valueStruct: ValueStructDao?,
    @SerialName("values")
    val values: List<ValueDao>
)