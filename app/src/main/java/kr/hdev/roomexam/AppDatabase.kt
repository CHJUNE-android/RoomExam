package kr.hdev.roomexam

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper

@Database(entities = arrayOf(Todo::class), version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun todoDao() : TodoDao
}