data class Post(
    val id: Long = 0,
    val ownerId: Long,
    val date: Long,
    val text: String,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val likes: Likes,
    val canEdit: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean
)

data class Likes(
    val count : Long,
    val userLikes : Boolean,
    val canLike : Boolean,
    val canPublish : Boolean
)

object WallService {
    var posts: Array<Post> = emptyArray()
    var nextId: Long = 1

    fun add(post: Post): Post {
        val newPost = post.copy(id = nextId)
        posts += newPost
        nextId += 1
        return posts.last()
    }

    fun update(findPost: Post): Boolean {
        for ((index, post) in posts.withIndex()) {
            if (post.id == findPost.id) {
                posts[index] = findPost.copy(ownerId = post.ownerId, date = post.date)
                return true
            }
        }
        return false
    }

    fun print() {
        for (post in posts) {
            println(post)
        }
        println("Следующий идентификатор (id) = $nextId")
    }

    fun clear() {
        posts = emptyArray()
        nextId = 1
    }
}


fun main() {
    val post1 = Post(
        123,
        14343,
        1460041200,
        "Пост номер один",
        0,
        true,
        Likes(555,true, true,true),
        true,
        false,
        true
    )
    val post2 = Post(
        224,
        134524,
        1460041200,
        "Пост номер два",
        0,
        true,
        Likes(1705,true, true,true),
        false,
        true,
        true
    )
    val post3 = Post(
        367,
        167867,
        1460041200,
        "Пост номер три",
        0,
        true,
        Likes(4,true, true,true),
        false,
        true,
        true
    )
    val post4 = Post(
        2,
        142,
        1460041200,
        "Пост номер четыре",
        0,
        true,
        Likes(800,true, true,true),
        false,
        true,
        true
    )
    WallService.add(post1)
    WallService.add(post2)
    WallService.add(post3)
    WallService.add(post4)
    WallService.print()

}