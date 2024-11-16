package app.app.samplekmp.app.profile.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(@PrimaryKey(autoGenerate = true)
                      val userId: Int,
                      val username: String,
                      val typeAccountId: Int,
                      val email: String,
                      val firebaseId: String,
                      val deviceToken: String,
                      val verify: Int,
                      val status: Int,
                      val lastConnection: String,
                      val latitude: Double,
                      val longitude: Double,
                      val city: String,
                      val country: String,
                      val codeCountry: String,
                      val gender: Int,
                      val searchGender: Int,
                      val birthday: String,
                      val zodiac: Int,
                      @Embedded
                      val profileEntity: ProfileEntity)

data class ProfileEntity(val situation: String,
                         val target: String,
                         val height: String,
                         val sport: String,
                         val bodyType: String,
                         val drink: String,
                         val smoke: String,
                         val occupation: String,
                         val company: String,
                         val goals: String,
                         val children: String,
                         val description: String,
                         val education: String,
                         val tattoo: String,
                         val religion: String,
                         val political: String)
