package app.app.samplekmp.app.profile.domain

import app.app.samplekmp.app.profile.data.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserFlowUseCase(private val userRepository: UserRepository) {

    operator fun invoke(): Flow<List<User>> {
        return userRepository.getUserFlow()
    }
}
