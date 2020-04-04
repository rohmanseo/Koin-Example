package com.rohman.koinexample.feature.contact

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.rohman.koinexample.model.ContactModel
import com.rohman.koinexample.repository.local.ContactDatabase
import com.rohman.koinexample.repository.local.ContactRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ContactViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: ContactRepository
    val allContacts: LiveData<List<ContactModel>>

    init {
        val contactDao = ContactDatabase.getInstance(application).contactDao()
        repository =
            ContactRepository(contactDao)
        allContacts = repository.allContacts
    }
    fun addContact(contactModel: ContactModel) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(contactModel)
    }
    fun deleteContact(contactModel: ContactModel) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(contactModel)
    }
}