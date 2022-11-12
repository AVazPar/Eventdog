package com.avazpar.eventdog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.avazpar.designsystem.foundations.EventdogTheme
import com.avazpar.eventdog.navigation.AppContent

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        WindowCompat.setDecorFitsSystemWindows(window, true)

        setContent {
            EventdogTheme {
                AppContent()
            }
        }
    }
}