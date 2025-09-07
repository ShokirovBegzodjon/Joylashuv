package uz.apphub.joylashuv.data.model

//* Shokirov Begzod  16.08.2025 *//

data class Location(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
    val email: String = "",
    val date: String = System.currentTimeMillis().toString()
)