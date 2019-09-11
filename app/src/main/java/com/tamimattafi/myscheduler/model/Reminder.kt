package com.tamimattafi.myscheduler.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tamimattafi.myscheduler.database.global.Tables

@Entity(tableName = Tables.TABLE_REMINDERS)
data class Reminder(
    @PrimaryKey(autoGenerate = true) val id : Long? = null,
    val nextRing : Long,
    val task : Long
)