package app.app.samplekmp

import androidx.compose.ui.window.ComposeUIViewController
import app.app.samplekmp.app.App
import app.app.samplekmp.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = { initKoin() }
) { App() }