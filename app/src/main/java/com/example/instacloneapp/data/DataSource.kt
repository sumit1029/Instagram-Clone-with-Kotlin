package com.example.instacloneapp.data

import com.example.instacloneapp.R
import com.example.instacloneapp.model.*

public class Datasource {
    fun loadStatus(): List<Status> {
        return listOf<Status>(
            Status(0, R.string.user1, R.drawable.profile1, R.string.user1),
            Status(1, R.string.user2, R.drawable.profile2, R.string.user2),
            Status(2, R.string.user3, R.drawable.profile3, R.string.user3),
            Status(3, R.string.user4, R.drawable.profile4, R.string.user4),
            Status(4, R.string.user5, R.drawable.profile5, R.string.user5),
            Status(5, R.string.user6, R.drawable.profile6, R.string.user6),
            Status(6, R.string.user7, R.drawable.profile7, R.string.user7),
            Status(7, R.string.user8, R.drawable.profile8, R.string.user8),
            Status(8, R.string.user9, R.drawable.profile9, R.string.user9),
            Status(9, R.string.user10, R.drawable.profile10, R.string.user10))
    }

    fun  loadPosts(): List<Posts> {
        return listOf<Posts>(
            Posts(0,R.string.user1, R.drawable.profile1, R.drawable.post1),
            Posts(1, R.string.user2, R.drawable.profile2, R.drawable.post2),
            Posts(2,R.string.user3, R.drawable.profile3, R.drawable.post3),
            Posts(3,R.string.user4, R.drawable.profile4, R.drawable.post4),
            Posts(4,R.string.user5, R.drawable.profile5, R.drawable.post5),
            Posts(5,R.string.user6, R.drawable.profile6, R.drawable.post6),
            Posts(6,R.string.user7, R.drawable.profile7, R.drawable.post7),
            Posts(7,R.string.user8, R.drawable.profile8, R.drawable.post8),
            Posts(8,R.string.user9, R.drawable.profile9, R.drawable.post9),
            Posts(9,R.string.user10, R.drawable.profile10, R.drawable.post10)
        )
    }

    fun loadChats(): List<Chats> {
        return listOf<Chats>(
            Chats(R.string.user2, R.drawable.profile2, R.string.msg1, "20h", false),
            Chats(R.string.user3, R.drawable.profile3, R.string.msg2, "1w", false),
            Chats(R.string.user4, R.drawable.profile4, R.string.msg3, "2d", false),
            Chats(R.string.user5, R.drawable.profile5, R.string.msg4, "2d", false),
            Chats(R.string.user6, R.drawable.profile6, R.string.msg5, "2m", false),
            Chats(R.string.user7, R.drawable.profile7, R.string.msg6, "1y", false),
            Chats(R.string.user8, R.drawable.profile8, R.string.msg7, "2w", false),
            Chats(R.string.user9, R.drawable.profile9, R.string.msg8, "2h", true),
            Chats(R.string.user10, R.drawable.profile10, R.string.msg9, "20h", true)
        )
    }

    fun loadNotification(): List<Chats> {
        return listOf<Chats>(
            Chats(R.string.user2, R.drawable.profile2, R.string.noti1, "20h", true),
            Chats(R.string.user3, R.drawable.profile3, R.string.noti2, "1w", true),
            Chats(R.string.user4, R.drawable.profile4, R.string.noti3, "2d", true),
            Chats(R.string.user5, R.drawable.profile5, R.string.noti4, "2d", true),
            Chats(R.string.user6, R.drawable.profile6, R.string.noti5, "2m", true),
            Chats(R.string.user7, R.drawable.profile7, R.string.noti6, "1y", true),
            Chats(R.string.user8, R.drawable.profile8, R.string.noti7, "2w", true),
            Chats(R.string.user9, R.drawable.profile9, R.string.noti8, "2h", true),
            Chats(R.string.user10, R.drawable.profile10, R.string.noti9, "20h", true)
        )
    }


    var list1: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )
    var list2: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )
    var list3: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )
    var list4: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )
    var list5: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )
    var list6: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )
    var list7: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )
    var list8: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )
    var list9: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )
    var list10: List<Status> = listOf(
        Status(1, R.string.user1, R.drawable.post1, R.string.user1)
    )

    var Feedlist1: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )
    var Feedlist2: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )
    var Feedlist3: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )
    var Feedlist4: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )
    var Feedlist5: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )
    var Feedlist6: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )
    var Feedlist7: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )
    var Feedlist8: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )
    var Feedlist9: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )
    var Feedlist10: List<Feeds> = listOf(
        Feeds(R.drawable.post1)
    )

    var Feedlist11: List<Feeds> = listOf(
        Feeds(R.drawable.post1),
        Feeds(R.drawable.post2),
        Feeds(R.drawable.post3),
        Feeds(R.drawable.post4),
        Feeds(R.drawable.post5),
        Feeds(R.drawable.post6),
        Feeds(R.drawable.post7),
        Feeds(R.drawable.post8),
        Feeds(R.drawable.post9),
        Feeds(R.drawable.post10),
        Feeds(R.drawable.profile1),
        Feeds(R.drawable.profile2),
        Feeds(R.drawable.profile3),
        Feeds(R.drawable.profile4),
        Feeds(R.drawable.profile5),
        Feeds(R.drawable.profile6),
        Feeds(R.drawable.profile7),
        Feeds(R.drawable.profile8),
        Feeds(R.drawable.profile9),
        Feeds(R.drawable.profile10),
    )
    var Feedlist12: List<Feeds> = listOf(
        Feeds(R.drawable.profile1),
        Feeds(R.drawable.profile2),
        Feeds(R.drawable.profile3),
        Feeds(R.drawable.profile4),
        Feeds(R.drawable.profile5),
        Feeds(R.drawable.profile6),
        Feeds(R.drawable.profile7),
        Feeds(R.drawable.profile8),
        Feeds(R.drawable.profile9),
        Feeds(R.drawable.profile10),
        Feeds(R.drawable.post1),
        Feeds(R.drawable.post2),
        Feeds(R.drawable.post3),
        Feeds(R.drawable.post4),
        Feeds(R.drawable.post5),
        Feeds(R.drawable.post6),
        Feeds(R.drawable.post7),
        Feeds(R.drawable.post8),
        Feeds(R.drawable.post9),
        Feeds(R.drawable.post10),
    )
    var Feedlist13: List<Feeds> = listOf(
        Feeds(R.drawable.post1),
        Feeds(R.drawable.post2),
        Feeds(R.drawable.post3),
        Feeds(R.drawable.post4),
        Feeds(R.drawable.post5),
        Feeds(R.drawable.post6),
        Feeds(R.drawable.post7),
        Feeds(R.drawable.post8),
        Feeds(R.drawable.post9),
        Feeds(R.drawable.post10),
        Feeds(R.drawable.profile1),
        Feeds(R.drawable.profile2),
        Feeds(R.drawable.profile3),
        Feeds(R.drawable.profile4),
        Feeds(R.drawable.profile5),
        Feeds(R.drawable.profile6),
        Feeds(R.drawable.profile7),
        Feeds(R.drawable.profile8),
        Feeds(R.drawable.profile9),
        Feeds(R.drawable.profile10),
    )


    var profiles: List<Profiles> = listOf(
        Profiles(R.string.user1, R.drawable.profile1, R.string.user1, R.string.about1, list1, Feedlist1),
        Profiles(R.string.user2, R.drawable.profile2, R.string.user1, R.string.about2, list2, Feedlist2),
        Profiles(R.string.user3, R.drawable.profile3, R.string.user1, R.string.about3, list3, Feedlist3),
        Profiles(R.string.user4, R.drawable.profile4, R.string.user1, R.string.about4, list4, Feedlist4),
        Profiles(R.string.user5, R.drawable.profile5, R.string.user1, R.string.about5, list5, Feedlist5),
        Profiles(R.string.user6, R.drawable.profile6, R.string.user1, R.string.about6, list6, Feedlist6),
        Profiles(R.string.user7, R.drawable.profile7, R.string.user1, R.string.about7, list7, Feedlist7),
        Profiles(R.string.user8, R.drawable.profile8, R.string.user1, R.string.about8, list8, Feedlist8),
        Profiles(R.string.user9, R.drawable.profile9, R.string.user1, R.string.about9, list9, Feedlist9),
        Profiles(R.string.user10, R.drawable.profile10, R.string.user1, R.string.about10, list10, Feedlist10)
    )

    fun loadProfiles(): List<Profiles> {
        return profiles
    }
}