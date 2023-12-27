package component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import message.DefaultMessageComponent
import success.DefaultSuccessComponent

interface RootComponent {
    val childStack: Value<ChildStack<*, Child>>
}

class DefaultRootComponent(
    context: ComponentContext,
) : ComponentContext by context, RootComponent {
    private val navigation = StackNavigation<ScreenConfig>()

    override val childStack = childStack(
        source = navigation,
        serializer = ScreenConfig.serializer(),
        initialConfiguration = ScreenConfig.Message,
        handleBackButton = true,
        childFactory = ::createChild,
    )

    private fun createChild(
        config: ScreenConfig,
        context: ComponentContext,
    ): Child = when (config) {
        ScreenConfig.Message -> Child.ScreenMessage(
            DefaultMessageComponent(
                context = context,
                showSuccessMessage = { navigation.push(ScreenConfig.Success(it)) },
            )
        )

        is ScreenConfig.Success -> Child.ScreenSuccess(
            DefaultSuccessComponent(
                context = context,
                message = config.message,
                navigateBack = { navigation.pop() },
            )
        )
    }
}
