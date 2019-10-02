package com.tamimattafi.myscheduler.repository

import com.tamimattafi.myscheduler.database.dao.RoutineDao
import com.tamimattafi.myscheduler.database.global.Tables
import com.tamimattafi.myscheduler.model.Properties
import com.tamimattafi.myscheduler.model.Routine
import com.tamimattafi.myscheduler.repository.global.BaseSearchRepository
import dagger.Reusable
import javax.inject.Inject

@Reusable
open class RoutineRepository @Inject constructor() : BaseSearchRepository<Routine, RoutineDao>() {

    override fun getSearchedProperty(): String = Properties.NAME

    override val table: String = Tables.ROUTINES

}