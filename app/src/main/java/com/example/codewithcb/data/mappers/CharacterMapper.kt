package com.example.codewithcb.data.mappers

import com.example.codewithcb.domain.models.CharacterLocation
import com.example.codewithcb.domain.models.CharacterModel
import com.example.codewithcb.remote.models.CharacterResponseModel

object CharacterMapper {

    fun mapCharacter(model: CharacterResponseModel): List<CharacterModel> {

        val list : ArrayList<CharacterModel> = arrayListOf()

        for(item in model.characters) {
            list.add( CharacterModel(
                created = item.created,
                gender = item.gender,
                id = item.id,
                image = item.image,
                characterLocation = CharacterLocation(item.characterLocation.name, item.characterLocation.url),
                name = item.name,
                species = item.species,
                status = item.status,
                type = item.type,
                url = item.url,
                isBookMarked = item.isBookMarked
            ))
        }
        return list
    }
}