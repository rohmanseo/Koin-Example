package com.rohman.koinexample.repository.local

import androidx.lifecycle.LiveData
import com.rohman.koinexample.model.ContactModel

class ContactRepository (private val contactDao: ContactDao){
    val allContacts : LiveData<List<ContactModel>> = contactDao.getAll()
    suspend fun insert(contactModel: ContactModel){
        contactDao.insert(contactModel)
    }

    suspend fun delete(contactModel: ContactModel) {
        contactDao.delete(contactModel)
    }
}