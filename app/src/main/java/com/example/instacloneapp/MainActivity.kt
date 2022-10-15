package com.example.instacloneapp

import android.os.Bundle
import android.preference.PreferenceActivity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.instacloneapp.data.Datasource
import com.example.instacloneapp.model.Chats
import com.example.instacloneapp.model.Posts
import com.example.instacloneapp.model.Status
import com.example.instacloneapp.ui.theme.InstaCloneAppTheme
import org.intellij.lang.annotations.JdkConstants
import javax.sql.DataSource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstaCloneAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
fun HeaderBar(navController: NavController){
    Row {
        Image(painter = painterResource(id = R.drawable.insta_written), contentDescription = null,
            contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(0.dp)
            .size(120.dp, 60.dp))
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {

            Icon(imageVector = Icons.Default.Add, contentDescription = null,
                modifier = Modifier
                    .padding(12.dp, 14.dp)
                    .border(2.dp, Color.Black, RectangleShape)
                    .size(22.dp)
                    )
            Icon(imageVector = Icons.Default.Send, contentDescription = null,
                modifier = Modifier
                    .padding(8.dp, 12.dp)
                    .rotate(-45f)
                    .clickable { navController.navigate(Screen.ChatScreen.route) }

            )
        }

    }
}

@Composable
fun StatusCard(status: Status, modifier: Modifier = Modifier) {
            Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(Color(250, 250, 250))) {
                Image(painter = painterResource(id = status.ImageResourceId), contentDescription = stringResource(
                    id = status.RestDesc
                ),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(8.dp, 4.dp, 8.dp, 4.dp)
                        .clip(CircleShape)
                        .size(66.dp)
                        .border(3.dp, Color(243, 46, 189), CircleShape)
                        .padding(3.dp)
                        .border(2.dp, Color.White, CircleShape),
                alignment = Alignment.Center)

                var name = stringResource(id = status.RestName)
                if(name.length > 8) {
                    Text(text = name.slice(0..6)+"..", modifier = Modifier
                        .padding(8.dp, 0.dp, 8.dp, 2.dp),
                    textAlign = TextAlign.Center)
                }
                else {

                    Text(
                        text = name, modifier = Modifier
                            .padding(8.dp, 0.dp, 8.dp, 2.dp),
                    textAlign = TextAlign.Center)
                }
            }
}

@Composable
private fun StatusList(statusList: List<Status>, modifier: Modifier = Modifier) {
    LazyRow(Modifier.background(Color(250, 250, 250))) {
        items(statusList){status->
            StatusCard(status = status)
        }
    }
}

@Composable
fun PostCard(post: Posts, modifier: Modifier = Modifier) {
    Card(Modifier.padding(0.dp), elevation = 14.dp) {
        Column {
            Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom) {
                Image(painter = painterResource(id = post.ImageResourceId), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .size(26.dp))
                Text(text = stringResource(id = post.RestName), textAlign = TextAlign.Center, fontSize = 14.sp,modifier = Modifier
                    .padding(4.dp, 0.dp, 0.dp, 10.dp))

                Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End){
                    Image(painter = painterResource(id = R.drawable.ic_baseline_pending_24), contentDescription = null,
                        contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clip(CircleShape)
                        .padding(0.dp, 8.dp, 8.dp, 8.dp)
                        .size(30.dp))
                }
            }
            
            Image(painter = painterResource(id = post.postImageResId), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(0.dp)
                .fillMaxWidth()
                .size(400.dp))

            Row(horizontalArrangement = Arrangement.Center) {
                Image(painter = painterResource(id = R.drawable.ic_baseline_thumb_up_24), contentDescription = null,
                modifier = Modifier
                    .padding(16.dp))

                Image(painter = painterResource(id = R.drawable.ic_baseline_mode_comment_24), contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp))

                Image(painter = painterResource(id = R.drawable.ic_baseline_send_24), contentDescription = null,
                    modifier = Modifier
                        .padding(16.dp))

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    Image(painter = painterResource(id = R.drawable.ic_baseline_bookmark_24), contentDescription = null,
                        modifier = Modifier
                            .padding(16.dp))
                }
            }
        }
    }
}

@Composable
private fun PostsList(statusList: List<Status>, postList: List<Posts>, modifier: Modifier = Modifier) {
    LazyColumn() {

        item {
            StatusList(statusList = statusList)
        }
        items(postList){post->
            PostCard(post = post)
        }
    }
}

@Composable
fun Footer(navController: NavController) {
    val selectedIndex = remember { mutableStateOf(0) }
    BottomNavigation(modifier = Modifier,
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 10.dp,) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home,"")
        },
            label = { Text(text = "Home") },
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
                navController.navigate(Screen.MainScreen.route)
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Search,"")
        },
            label = { Text(text = "Search") },
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.PlayArrow,"")
        },
            label = { Text(text = "Reels") },
            selected = (selectedIndex.value == 2),
            onClick = {
                selectedIndex.value = 2
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Favorite,"")
        },
            label = { Text(text = "Favorite") },
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person,"")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 4),
            onClick = {
                selectedIndex.value = 4
            })
    }
}


@Composable
fun HomePage(navController: NavController) {
    Scaffold(
        topBar = { HeaderBar(navController)},
        bottomBar = { Footer(navController)}
    ) {
        Modifier.background(color = Color.White)

        Column(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp)) {
//            StatusList(statusList = Datasource().loadStatus())
             PostsList(statusList = Datasource().loadStatus(), postList = Datasource().loadPosts())
        }
    }
}

@Composable
fun ChatHeader(navController: NavController){
    Row(modifier = Modifier
        .padding(0.dp, 0.dp, 0.dp, 0.dp)
        .border(2.dp, Color.LightGray)
        .fillMaxWidth(),
    horizontalArrangement = Arrangement.Center) 
    {
        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,
        modifier = Modifier
            .clickable { navController.navigate(Screen.MainScreen.route) }
            .size(55.dp)
            .padding(0.dp, 10.dp, 0.dp, 20.dp))
        Spacer(modifier = Modifier.padding(35.dp, 0.dp, 35.dp, 0.dp))
        Text(text = stringResource(id = R.string.user1), fontSize = 20.sp,
        modifier = Modifier
            .padding(0.dp, 10.dp, 0.dp, 20.dp))
        Spacer(modifier = Modifier.padding(45.dp, 0.dp, 35.dp, 0.dp))
        Icon(imageVector = Icons.Default.Star, contentDescription = null,
            modifier = Modifier
                .padding(0.dp, 10.dp, 15.dp, 20.dp))
    }
}

@Composable
fun ChatCard(chat: Chats, modifier: Modifier = Modifier){
        Row(Modifier.fillMaxWidth()) {
            Image(painter = painterResource(id = chat.ImageResourceId), contentDescription = stringResource(
                id = chat.RestName
            ),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp, 4.dp, 8.dp, 4.dp)
                    .clip(CircleShape)
                    .size(66.dp)
                    .border(2.dp, Color.White, CircleShape)
            )
            Column {
                Text(text = stringResource(id = chat.RestName))
                Row(modifier = Modifier.fillMaxHeight(),
                verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(id = chat.RestDesc))
                    Spacer(modifier = Modifier.padding(10.dp))
                    Text(text = chat.time)

                }
            }
            Row(Modifier.fillMaxWidth().padding(0.dp, 20.dp, 20.dp, 0.dp),
            horizontalArrangement = Arrangement.End) {
                if(!chat.seen){
                    Icon(imageVector = Icons.Filled.AddCircle, contentDescription = null,
                        modifier = Modifier
                            .background(Color.Blue)
                            .clip(CircleShape)
                            .size(5.dp)
                            .border(6.dp, Color.Blue, CircleShape)
                            .padding(0.dp, 50.dp, 0.dp, 0.dp))
                }
            }

        }
    }


@Composable
private fun ChatsList(chatList: List<Chats>, modifier: Modifier = Modifier) {
    LazyColumn(Modifier.padding(2.dp, 4.dp, 0.dp, 0.dp)) {
        items(chatList){chat->
            ChatCard(chat = chat)
        }
    }
}

@Composable
fun ChatPage(navController: NavController) {
    Scaffold(
        topBar = { ChatHeader(navController) },
    )
    {
        ChatsList(chatList = Datasource().loadChats())
    }

}



