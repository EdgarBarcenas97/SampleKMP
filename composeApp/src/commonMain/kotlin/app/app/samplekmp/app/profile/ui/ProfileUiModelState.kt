package app.app.samplekmp.app.profile.ui

import app.app.samplekmp.app.profile.domain.User

data class ProfileUiModelState(
    val loading: Boolean = false,
    val user: User? = null,
    val error: Throwable? = null)
