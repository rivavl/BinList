package com.marina.binlist.di.module

import com.marina.binlist.data.remote.CardApi
import com.marina.binlist.data.remote.RetrofitInstance
import com.marina.binlist.data.repository.BINRepositoryImpl
import com.marina.binlist.di.annotations.ApplicationScope
import com.marina.binlist.domain.repository.BINRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @ApplicationScope
    @Binds
    fun bindBINRepository(impl: BINRepositoryImpl): BINRepository

    companion object {
        @Provides
        fun provideCardApi(): CardApi {
            return RetrofitInstance.cardApi
        }
    }

}