package com.tamimattafi.myscheduler.database.dao

import androidx.room.Dao
import com.tamimattafi.myscheduler.database.dao.global.BaseDao
import com.tamimattafi.myscheduler.model.Routine

@Dao
interface RoutineDao : BaseDao<Routine>
