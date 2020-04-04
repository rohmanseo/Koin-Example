package com.rohman.koinexample.repository.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rohman.koinexample.Constant.Companion.CONTACT_TABLE
import com.rohman.koinexample.model.ContactModel

@Database(entities = arrayOf(ContactModel::class), version = 1)
abstract class ContactDatabase : RoomDatabase() {
    companion object {

        private var instance: ContactDatabase? = null
        fun getInstance(context: Context): ContactDatabase {
            val tempInatance =
                instance
            if (tempInatance != null) {
                return instance as ContactDatabase
            }
            synchronized(this) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ContactDatabase::class.java,
                    CONTACT_TABLE
                ).fallbackToDestructiveMigration().build()
                return instance as ContactDatabase
            }
        }

    }

    abstract fun contactDao(): ContactDao
}