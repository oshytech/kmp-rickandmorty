package tech.oshy.rickmortyapp

import androidx.compose.ui.window.ComposeUIViewController
import tech.oshy.rickmortyapp.di.initKoin

fun MainViewController() = ComposeUIViewController(configure = { initKoin()}) { App() }