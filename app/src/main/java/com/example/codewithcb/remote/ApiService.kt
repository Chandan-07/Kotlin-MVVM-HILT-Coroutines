package com.example.codewithcb.remote

import com.example.codewithcb.remote.models.CharacterModel
import com.example.codewithcb.remote.models.CharacterResponseModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("character")
    suspend fun getCharacters(): CharacterResponseModel

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: Long): CharacterModel
}