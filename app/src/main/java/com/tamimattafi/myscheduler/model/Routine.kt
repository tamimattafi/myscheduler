package com.tamimattafi.myscheduler.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.myscheduler.database.global.Tables

@Entity(tableName = Tables.TABLE_ROUTINES)
data class Routine(
    @PrimaryKey(autoGenerate = true) val id : Long? = null,
    var icon : Long?,
    var name : String = "",
    var description : String = "",
    var importance : Int,
    var size : Int,
    var startDay : Int
)