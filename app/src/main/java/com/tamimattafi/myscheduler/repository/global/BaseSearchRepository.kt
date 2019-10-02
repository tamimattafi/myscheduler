package com.tamimattafi.myscheduler.repository.global

import com.tamimattafi.myscheduler.database.global.BaseDao
import com.tamimattafi.myscheduler.database.global.QueryBuilder
import com.tamimattafi.myscheduler.repository.global.RepositoryContract.SearchBase

abstract class BaseSearchRepository<T, DAO : BaseDao<T>> : BaseRepository<T, DAO>(), SearchBase<T> {

    private var searchQuery: String? = null


    abstract fun getSearchedProperty(): String

    override fun updateSearchQuery(searchQuery: String?) {
        this.searchQuery = searchQuery
    }

    override fun getQuery(): QueryBuilder = searchQuery?.let {
        QueryBuilder()
            .selectFrom(table)
            .search(getSearchedProperty(), it)
            .orderBy(getSearchedProperty(), QueryBuilder.Direction.ASCENDING)
    } ?: super.getQuery()

}