package com.github.sseung416.chattingApplication.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen(onNavigateToChat: () -> Unit) {
    var userName by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        UserNameField(userName = userName, onChange = { input -> userName = input })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onNavigateToChat.invoke() }) {
            Text(text = "채팅 참여하기!")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserNameField(userName: String, onChange: (String) -> Unit) {
    OutlinedTextField(
        value = userName,
        onValueChange = onChange,
        placeholder = { Text(text = "이름") },
    )
}

@Composable
@Preview(showSystemUi = true)
fun PreviewLoginScreen() {
    LoginScreen {}
}

@Composable
@Preview(showBackground = true)
fun PreviewUserNameField() {
    var name by remember { mutableStateOf("내 이름은 바부") }
    UserNameField(userName = name, onChange = { input -> name = input })
}