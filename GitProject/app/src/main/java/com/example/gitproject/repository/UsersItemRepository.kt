package com.example.gitproject.repository

import com.example.gitproject.model.UsersItem

object UsersItemRepository {
     val usersItemList = mutableListOf<UsersItem>(
        UsersItem(
            avatar_url = "https://avatars.githubusercontent.com/u/60785366?v=4",
            id = 60785366,
            login = "basarYargici",
            node_id = "MDQ6VXNlcjYwNzg1MzY2=",
            type = "User"
        ),
        UsersItem(
            avatar_url = "https://avatars.githubusercontent.com/u/1?v=4",
            id = 1,
            login = "mojombo",
            node_id = "MDQ6VXNlcjE=",
            type = "User"
        ),
        UsersItem(
            avatar_url = "https://avatars.githubusercontent.com/u/2?v=4",
            id = 2,
            login = "defunkt",
            node_id = "MDQ6VXNlcjI=",
            type = "User"
        ),
        UsersItem(
            avatar_url = "https://avatars.githubusercontent.com/u/3?v=4",
            id = 3,
            login = "pjhyett",
            node_id = "MDQ6VXNlcjM=",
            type = "User"
        ),
        UsersItem(
            avatar_url = "https://avatars.githubusercontent.com/u/4?v=4",
            id = 4,
            login = "wycats",
            node_id = "MDQ6VXNlcjQ=",
            type = "User"
        )
    )
}