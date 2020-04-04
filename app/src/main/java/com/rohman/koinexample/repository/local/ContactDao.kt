package com.rohman.koinexample.repository.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.rohman.koinexample.Constant.Companion.CONTACT_TABLE
import com.rohman.koinexample.model.ContactModel

@Dao
interface ContactDao {
    @Query("SELECT * FROM $CONTACT_TABLE")
    fun getAll(): LiveData<List<ContactModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg contactModel: ContactModel)

    @Delete
    fun delete(contactModel: ContactModel)
}