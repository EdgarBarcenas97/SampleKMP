package app.app.samplekmp.app.profile.data

import app.app.samplekmp.app.profile.domain.Profile
import app.app.samplekmp.app.profile.domain.User
import app.app.samplekmp.app.profile.domain.toProfileEntity
import app.app.samplekmp.app.profile.domain.toUserEntity
import kotlinx.coroutines.flow.map

class UserRepository(private val userDao: UserDao) {

    suspend fun insertUser() {
        val user = User(
            firebaseId = "Joel",
            typeAccountId = 2263,
            email = "userForm.email",
            username = "userForm.username",
            gallery = listOf(),
            deviceToken = "Flint",
            userId = "1967",
            verify = 1,
            status = 8154,
            lastConnection = "4285L",
            latitude = 82.477,
            longitude = 64.497,
            city = "Thanh",
            codeCountry = "mx",
            country = "Jaclyn",
            gender = 1,
            searchGender = 2,
            birthday = "userForm.birthday",
            zodiac = 1,
            profile = Profile(
                height = "",
                sport = "",
                bodyType = "",
                drink = "",
                smoke = "",
                occupation = "",
                company = "",
                goals = "",
                children = "",
                description = "",
                education = "",
                tattoo = "",
                religion = "",
                situation = "",
                target = "1",
                political = ""
            )
        )
        userDao.insertUser(user.toUserEntity())
    }

    suspend fun insertProfile(profile: Profile) {
        val user = userDao.getUser().copy(profileEntity = profile.toProfileEntity())
        userDao.insertUser(user)
    }

    suspend fun getUser(): User {
        return userDao.getUser().toUser()
    }

    fun getUserFlow() = userDao.getUserFlow().map { it.map { userEntity: UserEntity -> userEntity.toUser() } }

    suspend fun deleteUser() {
        userDao.deleteUser()
    }
}
