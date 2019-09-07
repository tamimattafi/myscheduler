package com.tamimattafi.myscheduler.model

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.myscheduler.database.Tables

@Entity(tableName = Tables.TABLE_ICONS)
data class Icon(
    @PrimaryKey(autoGenerate = true) val id : Long? = null,
    @DrawableRes val background : Int,
    @DrawableRes val vector : Int,
    @ColorInt val tint : Int
)