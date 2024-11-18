package app.app.samplekmp.app.profile.domain

import app.app.samplekmp.app.profile.data.UserEntity

data class User(val firstName: String,
                val lastName: String,
                val email: String,
                val phoneNumber: String,
                val password: String)

fun User.toUserEntity() = UserEntity(
    firstName = firstName,
    lastName = lastName,
    email = email,
    phoneNumber = phoneNumber,
    password = password)
