package com.rohman.koinexample.repository.di

import android.app.Application
import com.rohman.koinexample.repository.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ContactApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ContactApp)
            modules(listOf(appModule))
        }
    }
}