package app.app.samplekmp.app.auth.signup

import app.app.samplekmp.core.extensions.default
import app.app.samplekmp.core.extensions.empty

data class SignUpProfileUiState(
    val loading: Boolean = false,
    var user: UserFormUi = UserFormUi(),
    var error: String = String.empty())

data class UserFormUi(
    val firebaseId: String = String.empty(),
    val email: String = String.empty(),
    val username: String = String.empty(),
    var gender: Int = Int.default(),
    var searchGender: Int = Int.default(),
    var birthday: String = String.empty(),
    var age: String = String.empty(),
    var zodiac: Int = Int.default(),
    var target: String = String.empty())
