package com.example.personalinfo.data

import com.example.datadiri.R
import com.example.personalinfo.model.Person

class Datasource {
    fun loadPersons(): List<Person> {
        return listOf(
            Person(R.string.name1, R.string.address1, R.drawable.image1),
            Person(R.string.name2, R.string.address2, R.drawable.image2),
            Person(R.string.name3, R.string.address3, R.drawable.image3)
        )
    }
}
