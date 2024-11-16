package app.app.samplekmp.app.profile.domain

import app.app.samplekmp.app.profile.data.UserRepository

class InsertUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke() = userRepository.insertUser()
}
