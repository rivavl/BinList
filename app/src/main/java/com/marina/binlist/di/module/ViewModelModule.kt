package com.marina.binlist.di.module

import androidx.lifecycle.ViewModel
import com.marina.binlist.di.annotations.ViewModelKey
import com.marina.binlist.presentation.view_model.InfoViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(InfoViewModel::class)
    fun bindInfoViewModel(viewModel: InfoViewModel): ViewModel
}