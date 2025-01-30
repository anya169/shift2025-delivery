package com.example.delivery.posttypes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.delivery.R
import com.example.delivery.data.PostTypesRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun PostTypesScreen(
    repository: PostTypesRepository,
    onItemSelected: (postTypeId: Long) -> Unit,
) {
    val scope = rememberCoroutineScope()
    var postTypesState by remember { mutableStateOf<postTypesState>(postTypesState.Initial) }

    LaunchedEffect(Unit) {
        loadPostTypes(repository, setPostTypesState = { postTypesState = it })
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.postTypes_title), modifier = Modifier.fillMaxWidth())

        when (val state = postTypesState) {
            is postTypesState.Initial,
            is postTypesState.Loading -> LoadingComponent()

            is postTypesState.Failure -> ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = {
                    scope.loadPostTypes(repository, setPostTypesState = { postTypesState = it })
                }
            )

            is postTypesState.Content -> ContentComponent(
                postTypes = state.postTypes,
                onItemClicked = onItemSelected,
            )
        }
    }
}


private fun CoroutineScope.loadPostTypes(
    repository: PostTypesRepository,
    setPostTypesState: (postTypesState) -> Unit,
) {
    launch {
        setPostTypesState(postTypesState.Loading)

        try {
            val postTypes = repository.getAll()
            setPostTypesState(postTypesState.Content(postTypes))
        } catch (ce: CancellationException) {
            throw ce
        } catch (ex: Exception) {
            setPostTypesState(postTypesState.Failure(ex.message))
        }
    }
}