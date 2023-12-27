package success

import com.arkivanov.decompose.ComponentContext

interface SuccessComponent {
    val message: String
    fun goBack()
}

class DefaultSuccessComponent(
    context: ComponentContext,
    private val navigateBack: () -> Unit,
    override val message: String,
) : ComponentContext by context, SuccessComponent {
    override fun goBack() {
        navigateBack()
    }
}
