package com.tamimattafi.myscheduler.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.myscheduler.database.global.Tables

@Entity(tableName = Tables.TABLE_ICONS)
data class Icon(
    @PrimaryKey(autoGenerate = true) val id : Long? = null,
    @DrawableRes var background: Int,
    @DrawableRes var vector: Int,
    @ColorRes var tint: Int
)