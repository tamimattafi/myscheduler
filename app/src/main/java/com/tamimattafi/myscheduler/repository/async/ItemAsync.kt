package com.tamimattafi.myscheduler.repository.async

import androidx.sqlite.db.SimpleSQLiteQuery
import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.repository.global.Callback
import com.tamimattafi.myscheduler.repository.global.RepositoryContract
import io.reactivex.Maybe

class ItemAsync<T>(private val dao: BaseDao<T>, callback: Callback<Maybe<T>>) :
    RepositoryContract.Async<SimpleSQLiteQuery, Maybe<T>>(callback) {

    override fun doWork(parameter: SimpleSQLiteQuery): Maybe<T> = dao.get(parameter)

}