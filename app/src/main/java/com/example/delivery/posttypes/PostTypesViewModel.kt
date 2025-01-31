package com.example.delivery.posttypes


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delivery.data.PostTypesRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class PostTypesViewModel(
    private val postTypesRepository: PostTypesRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<postTypeState>(postTypeState.Initial)
    val state: StateFlow<postTypeState> = _state

    fun loadPostTypes() {
        viewModelScope.launch {
            _state.value = postTypesState.Loading

            try {
                val postTypes = PostTypesRepository.getAll()
                _state.value = PostTypeState.Content(postTypes)
            } catch (ce: CancellationException) {
                throw ce
            } catch (ex: Exception) {
                _state.value = PostTypeState.Failure(ex.localizedMessage.orEmpty())
            }
        }
    }
}