package com.example.facebook.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.facebook.R
import com.example.facebook.core.theme.Blue
import com.example.facebook.core.theme.Grey
import com.example.facebook.core.theme.White
import com.example.facebook.core.utils.validateEmail
import com.example.facebook.core.utils.validatePassword
import com.example.facebook.ui.components.CustomTextField

@Composable
fun LoginScreen(onLoginSuccess: () -> Unit) {
    val emailState = rememberTextFieldState()
    val passwordState = rememberTextFieldState()

    var isEmailInteracted by remember { mutableStateOf(false) }
    var isPasswordInteracted by remember { mutableStateOf(false) }

    val emailError by remember {
        derivedStateOf {
            val text = emailState.text.toString()
            if (text.isNotEmpty() || isEmailInteracted) validateEmail(text) else null
        }
    }

    val passwordError by remember {
        derivedStateOf {
            val text = passwordState.text.toString()
            if (text.isNotEmpty() || isPasswordInteracted) validatePassword(text) else null
        }
    }

//    // AutoValidateMode for email like flutter
//    LaunchedEffect(emailState.text) {
//        val currentText = emailState.text.toString()
//
//        if (currentText.isNotEmpty()) isUserInteracted = true
//
//        if (isUserInteracted) emailError = validateEmail(currentText)
//    }
//
//    // AutoValidateMode for password like flutter
//    LaunchedEffect(passwordState.text) {
//        val currentText = passwordState.text.toString()
//
//        if (currentText.isNotEmpty()) isUserWriteInPasswordField = true
//
//        if (isUserWriteInPasswordField) passwordError = validatePassword(currentText)
//    }

    Scaffold() { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_facebook_logo),
                contentDescription = "logo",
                tint = Blue,
                modifier = Modifier.size(120.dp),
            )
            Spacer(modifier = Modifier.height(88.dp))
            CustomTextField(
                state = emailState,
                placeholder = "Mobile Number or Email Address",
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email,
                errorMessage = emailError
            )
            Spacer(modifier = Modifier.height(16.dp))
            CustomTextField(
                state = passwordState,
                placeholder = "Password",
                imeAction = ImeAction.Done,
                isPassword = true,
                keyboardType = KeyboardType.Password,
                errorMessage = passwordError
            )
            Spacer(modifier = Modifier.height(32.dp))
            ElevatedButton(
                onClick = {
                    isEmailInteracted = true
                    isPasswordInteracted = true

                    val currentEmailErr = validateEmail(emailState.text.toString())
                    val currentPassErr = validatePassword(passwordState.text.toString())

                    if (currentEmailErr == null && currentPassErr == null) {
                        onLoginSuccess()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = Blue,
                    contentColor = White
                )
            ) {
                Text("Login", fontSize = 16.sp)
            }

            TextButton(
                onClick = {},
                colors = ButtonDefaults.textButtonColors(
                    contentColor = Grey
                )
            ) {
                Text("Forgotten Password ?")
            }

            Spacer(Modifier.weight(1f))

            OutlinedButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(color = Blue, width = 1.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Blue,
                )
            ) { Text("Create Account", fontSize = 16.sp) }

            Spacer(modifier = Modifier.size(8.dp))

            Image(
                painter = painterResource(R.drawable.meta_logo),
                contentDescription = "Meta Logo",
            )
        }
    }
}