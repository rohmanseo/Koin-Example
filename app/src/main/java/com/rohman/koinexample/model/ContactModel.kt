package com.rohman.koinexample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rohman.koinexample.Constant.Companion.CONTACT_TABLE

@Entity(tableName = CONTACT_TABLE)
data class ContactModel(
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "description") val description: String?
)