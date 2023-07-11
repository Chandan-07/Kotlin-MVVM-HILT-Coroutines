package com.example.codewithcb.data

import com.example.codewithcb.data.mappers.CharacterMapper
import com.example.codewithcb.domain.GetCharacterRepository
import com.example.codewithcb.remote.ApiService
import com.example.codewithcb.remote.NetworkResults
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCharacterRepoImpl @Inject constructor (private val apiService: ApiService): GetCharacterRepository {
    override suspend fun getCharacters() = flow {
        emit(NetworkResults.Loading(true))
        val response = apiService.getCharacters()
        emit(NetworkResults.Success(CharacterMapper.mapCharacter(response)))
    }.catch { e ->
        emit(NetworkResults.Failure(e.message ?: "Unknown Error"))
    }
}