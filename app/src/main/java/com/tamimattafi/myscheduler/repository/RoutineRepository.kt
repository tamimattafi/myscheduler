package com.tamimattafi.myscheduler.repository

import com.tamimattafi.myscheduler.database.dao.RoutineDao
import com.tamimattafi.myscheduler.database.global.Tables
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.repository.global.BaseRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
class RoutineRepository @Inject constructor() : BaseRepository<Routine, RoutineDao>() {

    override val table: String = Tables.TABLE_ROUTINES


}