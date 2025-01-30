package com.example.delivery.cities

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
import com.example.delivery.data.CitiesRepository
import com.example.delivery.cities.ContentComponent
import com.example.delivery.cities.ErrorComponent
import com.example.delivery.cities.LoadingComponent
import com.example.delivery.cities.citiesState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException

@Composable
fun CitiesScreen(
    repository: CitiesRepository,
    onItemSelected: (cityId: Long) -> Unit,
) {
    val scope = rememberCoroutineScope()
    var citiesState by remember { mutableStateOf<citiesState>(citiesState.Initial) }

    LaunchedEffect(Unit) {
        loadcities(repository, setcitiesState = { citiesState = it })
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = stringResource(id = R.string.cities_title), modifier = Modifier.fillMaxWidth())

        when (val state = citiesState) {
            is citiesState.Initial,
            is citiesState.Loading -> LoadingComponent()

            is citiesState.Failure -> ErrorComponent(
                message = state.message ?: stringResource(id = R.string.error_unknown_error),
                onRetry = {
                    scope.loadcities(repository, setcitiesState = { citiesState = it })
                }
            )

            is citiesState.Content -> ContentComponent(
                cities = state.cities,
                onItemClicked = onItemSelected,
            )
        }
    }
}


private fun CoroutineScope.loadcities(
    repository: CitiesRepository,
    setcitiesState: (citiesState) -> Unit,
) {
    launch {
        setcitiesState(citiesState.Loading)

        try {
            val cities = repository.getAll()
            setcitiesState(citiesState.Content(cities))
        } catch (ce: CancellationException) {
            throw ce
        } catch (ex: Exception) {
            setcitiesState(citiesState.Failure(ex.message))
        }
    }
}