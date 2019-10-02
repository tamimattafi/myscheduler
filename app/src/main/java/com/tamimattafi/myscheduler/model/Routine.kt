package com.tamimattafi.myscheduler.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.myscheduler.database.global.Tables

@Entity(tableName = Tables.ROUTINES)
data class Routine(
    @PrimaryKey(autoGenerate = true) val id : Long? = null,
    var isActive: Boolean = false,
    var icon: Long? = null,
    var name : String = "",
    var description : String = "",
    var importance: Int = Importance.IMPORTANCE_NORMAL,
    var days: Int = 7,
    var startDay: Int = 1
)