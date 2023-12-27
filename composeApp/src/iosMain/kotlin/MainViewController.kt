import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import component.DefaultRootComponent
import component.RootComponent

fun MainViewController() = ComposeUIViewController {
    val root: RootComponent = remember {
        DefaultRootComponent(
            context = DefaultComponentContext(LifecycleRegistry()),
        )
    }
    App(root)
}
