package com.example.codewithcb.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codewithcb.domain.GetCharacterRepository
import com.example.codewithcb.domain.models.CharacterModel
import com.example.codewithcb.remote.NetworkResults
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class CharacterViewModel @Inject constructor(
    private val getCharacterRepository: GetCharacterRepository
) : ViewModel() {

    private var _movieResponse = MutableLiveData<NetworkResults<List<CharacterModel>>>()
        val movieResponse: LiveData<NetworkResults<List<CharacterModel>>> = _movieResponse

    init {
        fetchAllMovies()
    }

    private fun fetchAllMovies() {
        viewModelScope.launch {
            getCharacterRepository.getCharacters().collect {
                _movieResponse.postValue(it)
            }
        }
    }
}