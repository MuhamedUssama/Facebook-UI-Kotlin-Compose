package com.example.facebook.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.OutputTransformation
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebook.core.theme.Black
import com.example.facebook.core.theme.Blue
import com.example.facebook.core.theme.Grey
import com.example.facebook.core.theme.Red

@Composable
fun CustomTextField(
    state: TextFieldState,
    placeholder: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction,
    isPassword: Boolean = false,
    errorMessage: String? = null,
) {
    var isPasswordVisible by remember { mutableStateOf(!isPassword) }
    val isError = errorMessage != null

    OutlinedTextField(
        state = state,
        isError = isError,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        placeholder = { Text(text = placeholder) },
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = Black
        ),
        lineLimits = TextFieldLineLimits.MultiLine(
            maxHeightInLines = 1
        ),
        outputTransformation = if (isPassword && !isPasswordVisible) {
            OutputTransformation {
                replace(0, length, "•".repeat(length))
            }
        } else {
            null
        },
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = "Visibility Icon",
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        },
        supportingText = {
            if (isError) {
                Text(
                    text = errorMessage,
                    color = Red,
                    fontSize = 12.sp
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
        ),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFD6DFF1).copy(alpha = 0.47f),
            unfocusedContainerColor = Color(0xFFD6DFF1).copy(alpha = 0.47f),
            errorContainerColor = Color(0xFFD6DFF1).copy(alpha = 0.47f),

            focusedBorderColor = Blue,
            unfocusedBorderColor = Grey,
            focusedLabelColor = Blue,
            errorBorderColor = Red
        )
    )
}