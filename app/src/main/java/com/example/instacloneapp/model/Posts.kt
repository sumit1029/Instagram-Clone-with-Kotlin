package com.example.instacloneapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Posts(val id: Int, @StringRes val RestName: Int, @DrawableRes val ImageResourceId: Int, @DrawableRes val postImageResId: Int)