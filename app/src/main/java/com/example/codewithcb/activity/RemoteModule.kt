package com.example.codewithcb.activity

import com.example.codewithcb.data.GetCharacterRepoImpl
import com.example.codewithcb.domain.GetCharacterRepository
import com.example.codewithcb.remote.ApiService
import com.example.codewithcb.remote.RetrofitBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    fun provideBlogService(): ApiService {
        return RetrofitBuilder.apiService
    }

    @Provides
    @Singleton
    fun provideCharacterRemote(characterRemote: GetCharacterRepoImpl): GetCharacterRepository {
        return characterRemote
    }
}
