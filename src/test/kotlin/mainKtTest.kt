import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class MainKtTest {

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExisting() {
        val service = WallService
        service.add(Post(
            1,
            14343,
            1460041200,
            "Пост номер один",
            0,
            true,
            Likes(555,true, true,true),
            true,
            false,
            true,
            Comments(1,true,true, false,false),
            null,
            arrayOf()

        ))
        service.add(Post(
            2,
            134524,
            1460041200,
            "Пост номер два",
            0,
            true,
            Likes(1705,true, true,true),
            false,
            true,
            true,
            Comments(2,true,true, false,false),
            null,
            arrayOf()
        ))
        service.add(Post(
            3,
            167867,
            1460041200,
            "Пост номер три",
            0,
            true,
            Likes(4,true, true,true),
            false,
            true,
            true,
            Comments(3,true,true, false,false),
            null,
            arrayOf()
        ))
        val update = Post(
            2,
            142,
            1460041200,
            "update",
            0,
            true,
            Likes(800,true, true,true),
            false,
            true,
            true,
            Comments(4,true,true, false,false),
            null,
            arrayOf()
        )

        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService
        service.add(Post(
            1,
            14343,
            1460041200,
            "Пост номер один",
            0,
            true,
            Likes(555,true, true,true),
            true,
            false,
            true,
            Comments(1,true,true, false,false),
            null,
            arrayOf()
        ))
        service.add(Post(
            2,
            134524,
            1460041200,
            "Пост номер два",
            0,
            true,
            Likes(1705,true, true,true),
            false,
            true,
            true,
            Comments(2,true,true, false,false),
            null,
            arrayOf()
        ))
        service.add(Post(
            3534,
            167867,
            1460041200,
            "Пост номер три",
            0,
            true,
            Likes(4,true, true,true),
            false,
            true,
            true,
            Comments(3,true,true, false,false),
            null,
            arrayOf()
        ))
        val update = Post(
            256,
            142,
            1460041200,
            "update",
            0,
            true,
            Likes(800,true, true,true),
            false,
            true,
            true,
            Comments(4,true,true, false,false),
            null,
            arrayOf()
        )

        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun add() {
        val service = WallService
        val newPost = service.add(Post(
            1234,
            142,
            1460041200,
            "Пост номер четыре",
            0,
            true,
            Likes(800,true, true,true),
            false,
            true,
            true,
            Comments(1,true,true, false,false),
            null,
            arrayOf()
        ))

        assertTrue(newPost.id > 0)
    }

    @Test
    fun createCommentSuccess() {
        val post = WallService.add(Post(1234,
            142,
            1460041200,
            "тест поста",
            0,
            true,
            Likes(800,true, true,true),
            false,
            true,
            true,
            Comments(4,true,true, false,false),
            null,
            arrayOf()))

        val comment = Comment(
            1,
            2424,
            4343454,
            "тест коментария"
        )

        val createdComment = WallService.createComment(post.id, comment)
        assertEquals(1,createdComment.id)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val comment = Comment(
            1,
            2,
            564564123,
            "второй тест коментария"
        )

        WallService.createComment(181, comment)
    }

}