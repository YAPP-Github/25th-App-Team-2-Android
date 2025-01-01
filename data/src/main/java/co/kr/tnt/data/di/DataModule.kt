package co.kr.tnt.data.di

import co.kr.tnt.data.repository.TnTRepositoryImpl
import co.kr.tnt.domain.repository.TnTRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataModule {

    @Binds
    abstract fun bindsTnTRepository(
        repository: TnTRepositoryImpl,
    ): TnTRepository
}
