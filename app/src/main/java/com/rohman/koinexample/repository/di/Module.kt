package com.rohman.koinexample.repository.di

import com.rohman.koinexample.feature.contact.ContactViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ContactViewModel(get()) }
}