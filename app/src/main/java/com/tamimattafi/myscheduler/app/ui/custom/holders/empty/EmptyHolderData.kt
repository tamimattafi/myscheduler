package com.tamimattafi.myscheduler.app.ui.custom.holders.empty

import androidx.annotation.DrawableRes

data class EmptyHolderData(
    val id: Int,
    val image: Int,
    val label: String,
    val description: String,
    val action: Int,
    val actionName: String,
    @DrawableRes val actionIcon: Int
)