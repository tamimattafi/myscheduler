package com.tamimattafi.myscheduler.database.dao

import androidx.room.Dao
import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.model.Task
@Dao
interface TaskDao : BaseDao<Task>
