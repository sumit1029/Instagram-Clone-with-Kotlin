package com.example.instacloneapp

import android.content.ClipData
import android.os.Bundle
import android.preference.PreferenceActivity
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.navigation.compose.rememberNavController
import com.example.instacloneapp.data.Datasource
import com.example.instacloneapp.model.*
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
fun PostCard(navController: NavController, post: Posts, modifier: Modifier = Modifier) {
    Card(Modifier.padding(0.dp), elevation = 14.dp) {
        Column {
            Row(horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom) {
                Image(painter = painterResource(id = post.ImageResourceId), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(4.dp)
                        .clip(CircleShape)
                        .size(26.dp)
                        .clickable {
                            navController.navigate(Screen.ProfileScreen.withArgs(post.id))
                        })
                Text(text = stringResource(id = post.RestName), textAlign = TextAlign.Center, fontSize = 14.sp,modifier = Modifier
                    .padding(4.dp, 0.dp, 0.dp, 10.dp)
                    .clickable {
                        navController.navigate(Screen.ProfileScreen.withArgs(post.id))
                    })

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
private fun PostsList(navController: NavController, statusList: List<Status>, postList: List<Posts>, modifier: Modifier = Modifier) {
    LazyColumn() {

        item {
            StatusList(statusList = statusList)
        }
        items(postList){post->
            PostCard(navController, post = post)
        }
    }
}

@Composable
fun Footer(navController: NavController) {
    val selectedIndex = rememberSaveable{ mutableStateOf(0) }
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
            label = { Text(text = "Activity") },
            selected = (selectedIndex.value == 3),
            onClick = {
                selectedIndex.value = 3
                navController.navigate(Screen.ActivityScreen.route)
            })

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Person,"")
        },
            label = { Text(text = "Profile") },
            selected = (selectedIndex.value == 4),
            onClick = {
                selectedIndex.value = 4
                navController.navigate(Screen.ProfileScreen.withArgs(0))
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
             PostsList(navController, statusList = Datasource().loadStatus(), postList = Datasource().loadPosts())
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
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 20.dp, 20.dp, 0.dp),
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

@Composable
fun FeedsCards(feed: Feeds) {
    Image(painter = painterResource(id = feed.ImageResourceId), contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(125.dp, 125.dp)
            .padding(0.dp, 0.dp, 2.dp, 2.dp))
}


@Composable
fun ProfileCard(profile: Profiles, modifier: Modifier = Modifier) {
        LazyColumn(Modifier.padding(0.dp, 15.dp, 0.dp, 0.dp)) {
            item { 
                Row(Modifier.fillMaxWidth()) {
                    Image(painter = painterResource(id = profile.ImageResourceId), contentDescription = stringResource(
                        id = profile.RestDesc
                    ),
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(8.dp, 4.dp, 8.dp, 4.dp)
                            .clip(CircleShape)
                            .size(96.dp)
                            .border(2.dp, Color.White, CircleShape))
                    Column(
                    horizontalAlignment = Alignment.End) {
                        Text(text = stringResource(id = profile.RestName), fontSize = 25.sp, modifier =
                        Modifier
                            .padding(0.dp, 0.dp, 20.dp, 0.dp), textAlign = TextAlign.Center)
                        Row(
                            Modifier
                                .padding(0.dp, 10.dp, 0.dp, 0.dp)
                                .fillMaxWidth(),
                        horizontalArrangement = Arrangement.End) {
                            Card(Modifier.padding(0.dp, 0.dp, 15.dp, 0.dp), elevation = 4.dp) {
                                Text(text = "Message", fontSize = 18.sp, modifier =
                                Modifier.padding(35.dp, 2.dp, 35.dp, 2.dp))
                            }
                            Card(Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp),elevation = 4.dp) {
                                Icon(imageVector = Icons.Default.Person, contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(4.dp))
                            }
                            Card(Modifier.padding(0.dp, 0.dp, 20.dp, 0.dp),elevation = 4.dp) {
                                Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = null,
                                modifier = Modifier
                                    .size(25.dp)
                                    .padding(4.dp))
                            }
                        }
                    }
                }
            }

            item {
                Column(Modifier.padding(4.dp, 20.dp, 0.dp, 10.dp)) {
                    Text(text = stringResource(id = profile.About), fontSize = 16.sp)
                }
            }

            item {
                Row(Modifier.padding(4.dp, 10.dp, 0.dp, 20.dp)) {
                    StatusList(statusList = profile.HignLights)
                }

            }

            item {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(4.dp)) {
                    Column(Modifier.padding(35.dp, 0.dp, 35.dp, 0.dp), horizontalAlignment = Alignment.Start) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = profile.NoOfPosts.toString(), textAlign = TextAlign.Center)
                            Text(text = "posts", textAlign = TextAlign.Center)
                        }

                    }
                    Column(Modifier.padding(25.dp, 0.dp, 25.dp, 0.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = profile.NoOfFollowers, textAlign = TextAlign.Center)
                            Text(text = "followers", textAlign = TextAlign.Center)
                        }

                    }
                    Column(Modifier.padding(25.dp, 0.dp, 35.dp, 0.dp), horizontalAlignment = Alignment.End) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = profile.NoOfFollwing.toString(), textAlign = TextAlign.Center)
                            Text(text = "following", textAlign = TextAlign.Center)
                        }

                    }
                }
            }

            item {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(20.dp)) {
                    Icon(imageVector = Icons.Default.List, contentDescription = null)
                }
            }

            items(profile.posts){post->
                FeedsCards(feed = post)
            }
        }
}

@Composable
fun ProfilePage(navController: NavController, id: Int) {
    Scaffold(
        topBar = { ChatHeader(navController = navController)},
        bottomBar = { Footer(navController = navController)}
    ) {
        ProfileCard(profile = Datasource().profiles[id])
    }
}

@Composable
fun NotificationPage(navController: NavController) {
    Scaffold(topBar = { ChatHeader(navController = navController)},
            bottomBar = { Footer(navController = navController)}) {
        ChatsList(chatList = Datasource().loadNotification())
        
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ShowProfile() {
    ProfileCard(profile = Datasource().profiles[0])
}
