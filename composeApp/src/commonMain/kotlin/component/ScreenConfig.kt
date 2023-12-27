package component

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenConfig {
    @Serializable
    data object Message : ScreenConfig()

    @Serializable
    data class Success(val message: String) : ScreenConfig()
}
