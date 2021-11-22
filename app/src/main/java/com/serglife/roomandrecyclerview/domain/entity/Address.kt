package com.serglife.roomandrecyclerview.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Address(
    val street: String,
    val number: Int
    ):Parcelable