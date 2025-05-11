import org.junit.Test
import org.junit.Assert.*

class MainKtTest {

    @Test
    fun updateExisting() {
        val service = WallService
        val post1 = Post(
            1,
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
            2,
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
            3,
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
            true
        )
        service.add(post1)
        service.add(post2)
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService
        val post1 = Post(
            1,
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
            2,
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
            3534,
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
            true
        )

        service.add(post1)
        service.add(post2)
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
            true
        ))

        assertTrue(newPost.id > 0)
    }
}