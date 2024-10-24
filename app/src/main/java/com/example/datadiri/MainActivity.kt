package com.example.datadiri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.datadiri.R
import com.example.personalinfo.data.Datasource
import com.example.personalinfo.model.Person
import com.example.personalinfo.ui.theme.PersonalInfoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalInfoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PersonalInfoApp()
                }
            }
        }
    }
}

@Composable
fun PersonalInfoApp() {
    val personList = Datasource().loadPersons()
    PersonList(personList = personList)
}

@Composable
fun PersonList(personList: List<Person>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(personList) { person ->
            PersonCard(person = person, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun PersonCard(person: Person, modifier: Modifier = Modifier) {
    Card(modifier = modifier) {
        Column {
            Image(
                painter = painterResource(person.imageResourceId),
                contentDescription = stringResource(person.nameResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(person.nameResourceId),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = stringResource(person.addressResourceId),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}

@Preview
@Composable
fun PersonCardPreview() {
    PersonCard(
        person = Person(R.string.name1, R.string.address1, R.drawable.image1)
    )
}
