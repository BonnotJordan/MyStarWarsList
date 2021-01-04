package com.example.mystarwarslist.di

import com.example.mystarwarslist.view.activities.MainActivity
import com.example.mystarwarslist.view.fragments.CategoriesListFragment
import com.example.mystarwarslist.view.fragments.FilmsListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity
    @ContributesAndroidInjector
    internal abstract fun contributeListFragment(): FilmsListFragment
    @ContributesAndroidInjector
    internal abstract fun contributeCategoriesListFragment(): CategoriesListFragment
}