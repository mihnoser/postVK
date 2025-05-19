import Attachments as Attachments

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
    val isFavorite: Boolean,
    val coments: Comments? = null,
    val views: Views? = null,
    val attachments: Array<Attachments> = emptyArray()
)

data class Likes(
    val count : Long,
    val userLikes : Boolean,
    val canLike : Boolean,
    val canPublish : Boolean
)

data class Comments(
    val count: Int,
    val canPost: Boolean,
    val groupsCanPost: Boolean,
    val canClose: Boolean,
    val canOpen: Boolean
)

data class Views(
    val count: Int
)

abstract class Attachments(val type: String)

class PhotoAttachments(val photo: Photo) : Attachments("photo")
class VideoAttachments(val video: Video) : Attachments("video")
class AudioAttachments(val audio: Audio) : Attachments("audio")
class DocAttachments(val doc: Doc) : Attachments("doc")
class LinkAttachments (val link: Link) :Attachments("link")

data class Photo(
    val id: Int,
    val albumId: Int,
    val ownerId: Int,
    val userId: Int,
    val text: String,
    val date: Int,
    val width: Int,
    val height: Int
)

data class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val description: String,
    val duration: Int,
    val date: Int
)

data class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String,
    val duration: Int,
    val url: String
)

data class Doc(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int,
    val ext: String,
    val url: String,
    val date: Int,
    val type: Int
)

data class Link(
    val url: String,
    val title: String,
    val caption: String,
    val description: String,
    val previewPage: String,
    val previewUrl: String
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

    val video1 = Video(20, 1, "QWEEN", "sing", 360, 190525)
    val audio1 = Audio(10, 12, "NTL", "nsk", 412, "../kjnk")
    val photo1 = Photo(7, 12, 7, 33, "madonna", 1554645434, 480, 640)
    val doc1 = Doc(9, 4, "news", 52, "pdf", "../klnkjn", 4565454, 1)
    val link1 = Link("../hgjdbfj", "UchiRu", "nkjfnkjn", "nkjnkjn", "njhb", "../jkkfknjvnb")

    val attachmentsVideo1 = VideoAttachments(video1)
    val attachmentsAudio1 = AudioAttachments(audio1)
    val attachmentsPhoto1 = PhotoAttachments(photo1)
    val attachmentsDoc1 = DocAttachments(doc1)
    val attachmentsLink1 = LinkAttachments(link1)

    val post1 = Post(
        123,
        14343,
        1460041200,
        "Пост номер один",
        0,
        true,
        Likes(555, true, true, true),
        true,
        false,
        true,
        Comments(8, true, true, true, true),
        null,
        arrayOf(attachmentsVideo1, attachmentsDoc1)
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
        true,
        Comments(8, true, true, true, true),
        null,
        arrayOf(attachmentsAudio1, attachmentsLink1, attachmentsDoc1)
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
        true,
        Comments(8, true, true, true, true),
        null,
        arrayOf(attachmentsVideo1, attachmentsAudio1)
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
        true,
        Comments(8, true, true, true, true),
        null,
        arrayOf(attachmentsPhoto1)
    )
    WallService.add(post1)
    WallService.add(post2)
    WallService.add(post3)
    WallService.add(post4)
    WallService.print()

}