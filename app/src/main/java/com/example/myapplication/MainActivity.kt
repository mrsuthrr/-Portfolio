package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Portfolio()
//                StateManagement()
            }

        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Portfolio() {
    val isOpen = remember {
        mutableStateOf(false)
    }

    Surface(
        shadowElevation = 8.dp,
        shape = RoundedCornerShape(12.dp),
        color = Color.White,
        border = BorderStroke(1.dp, Color.Black),
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    )
    {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.profile), contentDescription = null,
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Divider()
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Deepak Suthar", style = TextStyle(
                    color = Color.Green, fontSize = 20.sp, fontWeight = FontWeight.Bold
                )
            )
            Text(text = "Android Compose Developer", style = MaterialTheme.typography.labelSmall)


            Spacer(modifier = Modifier.height(12.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.instagram), contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "instagram", style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Row {
                Image(
                    painter = painterResource(id = R.drawable.github), contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
                Text(
                    text = "Github", style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedButton(onClick = { isOpen.value = !isOpen.value }) {
                Text(text = "My Project", color = Color.Black)
            }


            if (isOpen.value) {
                LazyColumn {
                    items(getProjectList()) {
                        ProjectItem(it)

                    }
                }

            }
        }

    }

}


@Composable
fun ProjectItem(project: Project) {

    Spacer(modifier = Modifier.height(8.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile), contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(text = project.name, style = MaterialTheme.typography.bodyMedium)
            Text(text = project.desc, style = MaterialTheme.typography.bodySmall)
        }
    }

}

fun getProjectList(): List<Project> {
    return listOf(
        Project(name = "Social Media App", desc = "Connect with your friends"),
        Project(name = "Media Player App", desc = "Listen Music endlessly"),
        Project(name = "Gaming Media App", desc = "God of war lover")
    )
}

data class Project(
    val name: String, val desc: String
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}