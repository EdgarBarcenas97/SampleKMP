package app.app.samplekmp.app.profile.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.app.samplekmp.app.profile.domain.User
import app.app.samplekmp.core.extensions.default

@Entity
data class UserEntity(@PrimaryKey(autoGenerate = true)
                      val userId: Int = Int.default(),
                      val firstName: String,
                      val lastName: String,
                      val email: String,
                      val phoneNumber: String,
                      val password: String)

fun UserEntity.toUser() = User(
    firstName = firstName,
    lastName = lastName,
    email = email,
    phoneNumber = phoneNumber,
    password = password)

