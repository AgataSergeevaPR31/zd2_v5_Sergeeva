package com.example.oclocktravel.presentation
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String
)

annotation class Entity(val tableName: String)
