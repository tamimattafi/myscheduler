package com.tamimattafi.myscheduler.database.dao

import androidx.room.Dao
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.model.Task
import io.reactivex.Flowable

@Dao
interface TaskDao : BaseDao<Task> {
    @RawQuery(observedEntities = [Task::class])
    override fun get(itemQuery: SimpleSQLiteQuery): Flowable<Task>

    @RawQuery(observedEntities = [Task::class])
    override fun getList(listQuery: SimpleSQLiteQuery): Flowable<List<Task>>
}
