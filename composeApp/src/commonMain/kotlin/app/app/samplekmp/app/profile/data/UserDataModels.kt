package app.app.samplekmp.app.profile.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import app.app.samplekmp.app.profile.domain.Profile
import app.app.samplekmp.app.profile.domain.User

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

fun UserEntity.toUser() = User(
    userId = userId.toString(),
    username = username,
    gallery = listOf(),
    typeAccountId = typeAccountId,
    email = email,
    firebaseId = firebaseId,
    deviceToken = deviceToken,
    verify = verify,
    status = status,
    lastConnection = lastConnection,
    latitude = latitude,
    longitude = longitude,
    city = city,
    country = country,
    codeCountry = codeCountry,
    gender = gender,
    searchGender = searchGender,
    birthday = birthday,
    zodiac = zodiac,
    profile = profileEntity.toProfile())

fun ProfileEntity.toProfile() = Profile(
    situation = situation,
    target = target,
    height = height,
    sport = sport,
    bodyType = bodyType,
    drink = drink,
    smoke = smoke,
    occupation = occupation,
    company = company,
    goals = goals,
    children = children,
    description = description,
    education = education,
    tattoo = tattoo,
    religion = religion,
    political = political)
