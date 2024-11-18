package app.app.samplekmp.app.profile.data

import app.app.samplekmp.app.profile.domain.User
import app.app.samplekmp.app.profile.domain.toUserEntity
import app.app.samplekmp.resources.composables.form.personalData.PersonalData
import kotlinx.coroutines.flow.map

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser(personalData: PersonalData, password: String) {
        val user = User(
            firstName = personalData.firstName,
            lastName = personalData.lastName,
            email = personalData.email,
            phoneNumber = personalData.phoneNumber,
            password = password
        )
        userDao.insertUser(user.toUserEntity())
    }

    suspend fun getUser(): User {
        return userDao.getUser().toUser()
    }

    fun getUserFlow() = userDao.getUserFlow().map { it.map { userEntity: UserEntity -> userEntity.toUser() } }

    suspend fun deleteUser() {
        userDao.deleteUser()
    }
}
