package com.example.booking

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "doctor_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var name: String,
    var address: String,
    var speciality:String,
    // var iamgeId: String
):Parcelable