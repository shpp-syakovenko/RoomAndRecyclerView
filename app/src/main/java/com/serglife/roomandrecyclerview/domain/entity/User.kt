package com.serglife.roomandrecyclerview.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class User(
    val id: Int,
    val name: String,
    val secondName: String,
    val age: Int,
    val address: Address = Address("street", 1)
):Parcelable