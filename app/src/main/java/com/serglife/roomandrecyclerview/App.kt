package com.serglife.roomandrecyclerview

import android.app.Application
import com.serglife.roomandrecyclerview.di.repositoryModule
import com.serglife.roomandrecyclerview.di.useCaseModule
import com.serglife.roomandrecyclerview.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            //printLogger(Level.DEBUG)
            modules(listOf(repositoryModule, useCaseModule, viewModelModule))
        }
    }
}