package message

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

interface MessageComponent {
    val text: StateFlow<String>
    fun onTextChanged(text: String)
    fun sendMessage()
}

class DefaultMessageComponent(
    context: ComponentContext,
    private val showSuccessMessage: (String) -> Unit,
) : ComponentContext by context, MessageComponent {
    override val text = MutableStateFlow("")
    override fun onTextChanged(text: String) {
        this.text.update { text }
    }

    override fun sendMessage() {
        showSuccessMessage(text.value)
    }
}
