package com.tamimattafi.myscheduler.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.myscheduler.database.global.Tables

@Entity(tableName = Tables.REMINDERS)
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id : Long? = null,
    var ring: Long,
    val task : Long
)