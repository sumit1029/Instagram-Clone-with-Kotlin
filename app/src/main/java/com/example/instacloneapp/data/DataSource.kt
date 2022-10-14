package com.example.instacloneapp.data

import com.example.instacloneapp.R
import com.example.instacloneapp.model.Posts
import com.example.instacloneapp.model.Status

class Datasource {
    fun loadStatus(): List<Status> {
        return listOf<Status>(
            Status(R.string.user1, R.drawable.profile1, R.string.user1),
            Status(R.string.user2, R.drawable.profile2, R.string.user2),
            Status(R.string.user3, R.drawable.profile3, R.string.user3),
            Status(R.string.user4, R.drawable.profile4, R.string.user4),
            Status(R.string.user5, R.drawable.profile5, R.string.user5),
            Status(R.string.user6, R.drawable.profile6, R.string.user6),
            Status(R.string.user7, R.drawable.profile7, R.string.user7),
            Status(R.string.user8, R.drawable.profile8, R.string.user8),
            Status(R.string.user9, R.drawable.profile9, R.string.user9),
            Status(R.string.user10, R.drawable.profile10, R.string.user10))
    }

    fun  loadPosts(): List<Posts> {
        return listOf<Posts>(
            Posts(R.string.user1, R.drawable.profile1, R.drawable.post1),
            Posts(R.string.user2, R.drawable.profile2, R.drawable.post2),
            Posts(R.string.user3, R.drawable.profile3, R.drawable.post3),
            Posts(R.string.user4, R.drawable.profile4, R.drawable.post4),
            Posts(R.string.user5, R.drawable.profile5, R.drawable.post5),
            Posts(R.string.user6, R.drawable.profile6, R.drawable.post6),
            Posts(R.string.user7, R.drawable.profile7, R.drawable.post7),
            Posts(R.string.user8, R.drawable.profile8, R.drawable.post8),
            Posts(R.string.user9, R.drawable.profile9, R.drawable.post9),
            Posts(R.string.user10, R.drawable.profile10, R.drawable.post10)
        )
    }
}