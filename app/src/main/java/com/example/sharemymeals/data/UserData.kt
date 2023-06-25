package values

import com.example.sharemymeals.data.User


class UserData {
    private val userList: MutableList<User> = mutableListOf()

    init {
        // Add three trial users to the list
        userList.add(User("John Doe", "doe123", "pass123", 10, 100))
        userList.add(User("Jane Smith", "smit456", "pass456", 5, 50))
        userList.add(User("Mike Johnson", "john789", "pass789", 8, 80))
    }

    fun getUserByUsername(username: String): User? {
        return userList.find { it.username == username }
    }}