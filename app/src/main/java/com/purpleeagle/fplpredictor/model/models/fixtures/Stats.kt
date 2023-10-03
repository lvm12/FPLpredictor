package com.purpleeagle.fplpredictor.model.models.fixtures

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class A (

    @SerialName("value"   ) var value   : Int? = null,
    @SerialName("element" ) var element : Int? = null

)