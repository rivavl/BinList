package com.marina.binlist.di.component

import android.app.Application
import com.marina.binlist.di.annotations.ApplicationScope
import com.marina.binlist.di.module.DataModule
import com.marina.binlist.di.module.ViewModelModule
import com.marina.binlist.presentation.fragment.InfoFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {
    fun inject(fragment: InfoFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }
}