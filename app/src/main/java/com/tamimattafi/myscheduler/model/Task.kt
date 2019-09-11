package com.tamimattafi.myscheduler.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.myscheduler.database.global.Tables

@Entity(tableName = Tables.TABLE_TASKS)
data class Task(
    @PrimaryKey(autoGenerate = true) val id : Long? = null,
    val icon : Long?,
    val name : String,
    val description : String,
    val routine : Long,
    val day : Int
)