package com.tamimattafi.myscheduler.database.global

import androidx.sqlite.db.SimpleSQLiteQuery

class QueryBuilder(var rawQuery : String = "") {

    fun selectFrom(table : String) : QueryBuilder {
        rawQuery = "SELECT * FROM $table "
        return this
    }

    fun deleteFrom(table: String) : QueryBuilder {
        rawQuery = "DELETE FROM $table "
        return this
    }

    fun where(field : String, operator : String, value : Any) : QueryBuilder {
        return whereClause("WHERE", field, operator, value)
    }

    fun and(field : String, operator : String, value : Any) : QueryBuilder {
        return whereClause("AND", field, operator, value)
    }

    fun or(field : String, operator : String, value : Any) : QueryBuilder {
        return whereClause("OR", field, operator, value)
    }

    fun orderBy(field: String, direction : String = Direction.ASCENDING) : QueryBuilder {
        rawQuery += "ORDER BY $field $direction "
        return this
    }

    fun limit(limit : Int, offset : Int = 0) : QueryBuilder {
        rawQuery += "LIMIT $limit OFFSET $offset "
        return this
    }

    fun search(field: String, searchQuery : String) : QueryBuilder {
        rawQuery += "WHERE $field LIKE '%$searchQuery%' "
        return this
    }

    fun build() : SimpleSQLiteQuery {
        return SimpleSQLiteQuery(rawQuery)
    }

    private fun whereClause(operation : String, field : String, operator : String, value : Any) : QueryBuilder {
        rawQuery += "$operation $field $operator '$value' "
        return this
    }


    object Direction {
        const val ASCENDING = "ASC"
        const val DESCENDING = "DESC"
    }



    object Custom {

        fun getAll(table : String) : SimpleSQLiteQuery
            = QueryBuilder().selectFrom(table).build()

        fun getItem(table: String, id: Int): SimpleSQLiteQuery
            = QueryBuilder().selectFrom(table).where("id", "=", id).build()

        fun deleteAll(table: String) : SimpleSQLiteQuery
            = QueryBuilder().deleteFrom(table).build()

    }

}
