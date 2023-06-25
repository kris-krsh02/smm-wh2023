package com.example.sharemymeals.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")

class User(
    var name: String,
    var username: String,
    var password: String,
    var swipeCount: Int,
    var pointsCount: Int
) /* {
    // Getters for the properties
    fun getUserName(): String {
        return name
    }

    fun get_Username(): String {
        return username
    }

    fun get_Password(): String {
        return password
    }

    fun getSwipeCount(): Int {
        return swipeCount
    }

    fun getPointsCount(): Int {
        return pointsCount
    }

}*/