package com.example.codewithcb.data.models

data class CharacterEntityModel(
    val created: String,
    val gender: String,
    val id: Int,
    val image: String,
    val characterLocation: CharacterLocationModel,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    var isBookMarked: Boolean
)
