package com.volvocars.weather.uikit.base.viewmodel

data class MessageMaster(
    val type: MessageTypeEnum,
    val state: MessageStateEnum,
    val message: String? = null,
    val messageResourceId: Int? = null,
    val viewId: Int? = null,
    var text: String = "",
)