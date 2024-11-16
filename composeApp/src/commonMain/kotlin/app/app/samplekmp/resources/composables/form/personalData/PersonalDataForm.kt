package app.app.samplekmp.resources.composables.form.personalData

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.stringResource
import app.app.samplekmp.resources.composables.TextField
import app.app.samplekmp.resources.composables.form.email.EmailField
import samplekmp.composeapp.generated.resources.Res
import samplekmp.composeapp.generated.resources.first_name
import samplekmp.composeapp.generated.resources.last_name
import samplekmp.composeapp.generated.resources.phone_number

@Composable
fun PersonalDataForm(
    modifier: Modifier = Modifier,
    state: PersonalDataFormState = rememberPersonalDataFormState()
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(16.dp)) {
        TextField(
            icon = Icons.Default.Person,
            label = stringResource(Res.string.first_name),
            state = state.firstName,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            icon = Icons.Default.Person,
            label = stringResource(Res.string.last_name),
            state = state.lastName,
            modifier = Modifier.fillMaxWidth()
        )
        EmailField(
            state = state.email,
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            icon = Icons.Default.Phone,
            label = stringResource(Res.string.phone_number),
            state = state.phoneNumber,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
