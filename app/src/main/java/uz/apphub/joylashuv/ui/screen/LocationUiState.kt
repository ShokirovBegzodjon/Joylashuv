package uz.apphub.joylashuv.ui.screen

import uz.apphub.joylashuv.data.model.Location

data class LocationUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val success: Boolean = false,

    val location: Location = Location(),
)
