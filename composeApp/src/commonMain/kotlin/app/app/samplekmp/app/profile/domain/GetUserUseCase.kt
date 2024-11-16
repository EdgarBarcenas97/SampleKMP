package app.app.samplekmp.app.profile.domain

import app.app.samplekmp.app.profile.data.UserRepository

class GetUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(): User {
        return userRepository.getUser()
    }

}
