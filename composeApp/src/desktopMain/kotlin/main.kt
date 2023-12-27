import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.decompose.extensions.compose.jetbrains.lifecycle.LifecycleController
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import component.DefaultRootComponent
import component.RootComponent

fun main() {
    val lifecycle = LifecycleRegistry()

    val root: RootComponent = runOnUiThread {
        DefaultRootComponent(
            context = DefaultComponentContext(lifecycle = lifecycle),
        )
    }
    application {
        val windowState = rememberWindowState()

        LifecycleController(lifecycle, windowState)

        Window(onCloseRequest = ::exitApplication, title = "DecomposeExample") {
            App(root)
        }
    }
}
