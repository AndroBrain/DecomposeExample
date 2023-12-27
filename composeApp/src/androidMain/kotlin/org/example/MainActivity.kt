package org.example

import App
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.retainedComponent
import component.DefaultRootComponent
import component.RootComponent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root: RootComponent = retainedComponent {
            DefaultRootComponent(it)
        }

        setContent {
            App(root)
        }
    }
}
