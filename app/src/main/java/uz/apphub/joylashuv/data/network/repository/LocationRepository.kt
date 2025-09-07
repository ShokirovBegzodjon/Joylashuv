package uz.apphub.joylashuv.data.network.repository

import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow
import uz.apphub.joylashuv.data.model.Location
import uz.apphub.joylashuv.utils.NetworkResult

//* Shokirov Begzod  16.08.2025 *//

interface LocationRepository {

    fun getUser(): FirebaseUser?
    suspend fun updateLocation(location: Location): Flow<NetworkResult<Boolean>>
}