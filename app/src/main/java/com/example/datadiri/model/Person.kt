package com.example.personalinfo.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Person(
    @StringRes val nameResourceId: Int,
    @StringRes val addressResourceId: Int,
    @DrawableRes val imageResourceId: Int
)
