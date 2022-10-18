package com.example.instacloneapp.model

import android.provider.Contacts
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Profiles(@StringRes val RestName: Int,
                    @DrawableRes val ImageResourceId: Int,
                    @StringRes val RestDesc: Int,
                    @StringRes val About: Int,
                    val HignLights: List<Status>,
                    val posts: List<Feeds>,
                    val NoOfPosts: Int = 1,
                    val NoOfFollowers: String = "50M",
                    val NoOfFollwing: Int = 9,
                    val follow: Boolean = true)
