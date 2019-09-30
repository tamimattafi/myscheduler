package com.tamimattafi.myscheduler.repository.async

import androidx.sqlite.db.SimpleSQLiteQuery
import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.repository.global.Callback
import com.tamimattafi.myscheduler.repository.global.RepositoryContract
import io.reactivex.Flowable

class ListAsync<T>(private val dao: BaseDao<T>, callback: Callback<Flowable<List<T>>>) :
    RepositoryContract.Async<SimpleSQLiteQuery, Flowable<List<T>>>(callback) {

    override fun doWork(parameter: SimpleSQLiteQuery): Flowable<List<T>> = dao.getList(parameter)

}