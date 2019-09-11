package com.tamimattafi.myscheduler.database.dao

import androidx.room.Dao
import androidx.room.RawQuery
import androidx.sqlite.db.SimpleSQLiteQuery
import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.model.Routine
import io.reactivex.Flowable

@Dao
interface RoutineDao : BaseDao<Routine> {
    @RawQuery(observedEntities = [Routine::class])
    override fun get(itemQuery: SimpleSQLiteQuery): Flowable<Routine>

    @RawQuery(observedEntities = [Routine::class])
    override fun getList(listQuery: SimpleSQLiteQuery): Flowable<List<Routine>>
}
