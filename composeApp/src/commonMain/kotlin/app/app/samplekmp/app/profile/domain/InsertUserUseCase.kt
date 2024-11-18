package app.app.samplekmp.app.profile.domain

import app.app.samplekmp.app.profile.data.UserRepository
import app.app.samplekmp.resources.composables.form.personalData.PersonalData

class InsertUserUseCase(private val userRepository: UserRepository) {

    suspend operator fun invoke(personalData: PersonalData, password: String) = userRepository.insertUser(personalData, password)
}
