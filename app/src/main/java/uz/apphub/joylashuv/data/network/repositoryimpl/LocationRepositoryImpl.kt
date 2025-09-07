package uz.apphub.joylashuv.data.network.repositoryimpl

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import uz.apphub.joylashuv.data.model.Location
import uz.apphub.joylashuv.data.network.repository.LocationRepository
import uz.apphub.joylashuv.utils.NetworkResult
import javax.inject.Inject

//* Shokirov Begzod  16.08.2025 *//

class LocationRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
) : LocationRepository {

    override suspend fun updateLocation(location: Location): Flow<NetworkResult<Boolean>> =
        callbackFlow {
            trySend(NetworkResult.loading())
            val currentUserId = auth.currentUser?.uid
            if (currentUserId.isNullOrEmpty()) {
                trySend(NetworkResult.error("Foydalanuvchi tizimga kirmagan."))
                channel.close()
                awaitClose { }
                return@callbackFlow
            }

            firestore.collection("users").document(location.email)
                .set(location)
                .addOnSuccessListener {
                    trySend(NetworkResult.success(true))
                    channel.close()
                }
                .addOnFailureListener { exception ->
                    trySend(
                        NetworkResult.error(
                            exception.localizedMessage ?: "Guruhni yangilashda xatolik"
                        )
                    )
                    channel.close()
                }
            awaitClose { }
        }

    override fun getUser() = auth.currentUser
}