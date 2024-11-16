package app.app.samplekmp.resources.extensions

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.selection.toggleable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp

fun Modifier.noRippleToggleable(
    value: Boolean,
    role: Role,
    onValueChange: (Boolean) -> Unit
): Modifier = composed {
    toggleable(
        value = value,
        indication = null,
        role = role,
        interactionSource = remember { MutableInteractionSource() },
        onValueChange = onValueChange
    )
}

fun Modifier.noInteractionSource(
    onItemSelectedListener: () -> Unit
): Modifier = composed {
    this.then(
        clickable(
            onClick = { onItemSelectedListener.invoke() },
            indication = null,
            interactionSource = remember { MutableInteractionSource() }
        )
    )
}

fun Modifier.fillMaxSizeOrFixHeightIfCondition(condition: Boolean, height: Dp): Modifier {
    return this then if (condition) Modifier.fillMaxSize()
    else Modifier
        .fillMaxWidth()
        .height(height)
}
