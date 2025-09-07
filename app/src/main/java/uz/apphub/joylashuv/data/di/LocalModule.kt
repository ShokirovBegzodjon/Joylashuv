package uz.apphub.joylashuv.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.apphub.joylashuv.data.network.repository.LocationRepository
import uz.apphub.joylashuv.data.network.repositoryimpl.LocationRepositoryImpl
import javax.inject.Singleton

//* Shokirov Begzod  10.06.2025 *//

@Module
@InstallIn(SingletonComponent::class)
interface LocalModule{

    @Binds
    @Singleton
    fun bindLocationRepository(impl: LocationRepositoryImpl): LocationRepository
}