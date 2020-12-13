package com.example.mystarwarslist.di

import android.app.Application
import com.example.mystarwarslist.MyStarWarsListApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, RetrofitModule::class, ActivityModule::class, AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }

    fun inject(myStarWarsListApplication: MyStarWarsListApplication)
}