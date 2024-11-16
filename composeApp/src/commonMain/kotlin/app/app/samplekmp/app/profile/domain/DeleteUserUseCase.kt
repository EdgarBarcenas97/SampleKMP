package app.app.samplekmp.app.profile.domain

import app.app.samplekmp.app.profile.data.UserRepository

class DeleteUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke() = userRepository.deleteUser()

}
