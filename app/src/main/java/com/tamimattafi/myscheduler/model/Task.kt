package com.tamimattafi.myscheduler.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.myscheduler.database.global.Tables

@Entity(tableName = Tables.TASKS)
data class Task(
    @PrimaryKey(autoGenerate = true) val id : Long? = null,
    var icon: Long?,
    var name: String,
    var description: String,
    var importance: Int,
    var routine: Long,
    var day: Int
)