import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.jetbrains.subscribeAsState
import component.Child
import component.RootComponent
import message.MessageScreen
import success.SuccessScreen

@Composable
fun App(root: RootComponent) {
    MaterialTheme {
        val childStack by root.childStack.subscribeAsState()

        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when (val instance = child.instance) {
                is Child.ScreenMessage -> MessageScreen(component = instance.component)
                is Child.ScreenSuccess -> SuccessScreen(component = instance.component)
            }
        }
    }
}
