package co.kr.tnt.domain.usecase

import co.kr.tnt.domain.repository.TnTRepository
import javax.inject.Inject

class TnTUseCase @Inject constructor(
    private val tntRepository: TnTRepository,
) {
    suspend operator fun invoke() {
        print(1)
    }
}
