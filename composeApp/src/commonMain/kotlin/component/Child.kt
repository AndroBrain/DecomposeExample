package component

import message.MessageComponent
import success.SuccessComponent

sealed class Child {
    data class ScreenMessage(val component: MessageComponent) : Child()
    data class ScreenSuccess(val component: SuccessComponent) : Child()
}
