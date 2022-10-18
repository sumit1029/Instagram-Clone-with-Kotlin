package com.example.instacloneapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


data class Stories(
                    @StringRes val RestName: Int,
                   @DrawableRes val ImageResourceId: Int,
                   @StringRes val RestDesc: Int)
