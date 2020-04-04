package com.rohman.koinexample.feature.contact

import com.rohman.koinexample.model.ContactModel

interface AdapterCallback {
    fun onItemClicked(contactModel: ContactModel)
}