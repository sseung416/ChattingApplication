package com.github.sseung416.chattingApplication.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ChatScreen() {

}

data class Chat(val userName: String, val text: String, val isMine: Boolean)

@Composable
fun ChatList(chats: List<Chat>) {
    LazyColumn {
        items(chats) { chat ->
            Bubble(chat = chat)
        }
    }
}

@Composable
fun Bubble(chat: Chat) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalAlignment = if (chat.isMine) Alignment.End else Alignment.Start
    ) {
        if (!chat.isMine) {
            Text(text = chat.userName)
            Spacer(modifier = Modifier.height(4.dp))
        }
        Text(
            text = chat.text,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(if (chat.isMine) Color.Magenta else Color.LightGray)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}

@Composable
@Preview(showSystemUi = true)
private fun PreviewChatList() {
    val chats = listOf(
        Chat(userName = "안녕", text = "sdf", isMine = false),
        Chat(userName = "하세요", text = "sdfddfkajsdfkasdjflkasdjflksjdlkfjaslkdfjlksdjflksadjflksdjflksjdflskdjflksdjfklsdjflksdjflksdjflksdjfjklsdfjlksfjkllkj", isMine = false),
        Chat(userName = "나야", text = "어쩔티비?", isMine = true),
        Chat(userName = "하세요", text = "sdf", isMine = false),
    )
    ChatList(chats = chats)
}

@Composable
@Preview(showBackground = true)
private fun PreviewMyBubble() {
    Bubble(Chat(isMine = true, text = "안녕하세요 나얌", userName = "최승연"))
}

@Composable
@Preview(showBackground = true)
private fun PreviewYourBubble() {
    Bubble(Chat(isMine = false, text = "안녕하세욤 너얌", userName = "큐티걸"))
}