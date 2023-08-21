data class Post(
    val id: Int, //1
    val ownerId: Int, //2
    val fromId: Int, //3
    val date: Long, //4
    val text: String, //5
    val reply_post_id: Int, //6
    val post_type: String = "starter", //7
    val can_pin: Boolean = false, //8
    val can_delete: Boolean = false, //9
    val can_edit: Boolean = false, //10
    val comments: Comments, //Объект
    var likes: Likes, //Объект
)

object WallService{
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post{
        posts += post
        return posts.last()
    }
}

data class Comment(
    val ownerId: Int,
    val text: String,
)

class Comments(){
    private var comments = emptyArray<Comment>()

    fun add(comment: Comment): Comment {
        comments += comment
        return comments.last()
    }

    fun size(): Int {
        return comments.size
    }
}

data class Like(
    val ownerId: Int,
)

class Likes{
    private var likes = emptyArray<Like>()

    fun add(ownerId: Int): Like {
        likes += Like(ownerId)
        return likes.last()
    }

    fun size(): Int {
        return likes.size
    }
}

fun main() {
    val post1 = WallService.add(Post(1, 376, 56, 1692333801, "Начало", 12, "regular", true, true, true, Comments(), Likes()))
    val post2 = WallService.add(Post(1, 242, 56, 1692420201, "Конец", 3, "regular", true, true, true, Comments(), Likes()))
    println(post1)
    println(post2)
    println(post1.likes.add(242))
    println(post1.likes.add(376))
    println(post1.likes.size())
    println("Текст поста: ${post1.text}")
    println(post1.comments.add(Comment(242, "Отличное начало")))
    println(post2.likes.add(242))
    println(post2.likes.add(376))
    println(post2.likes.add(12))
    println(post2.likes.add(25))
    println(post2.likes.size())
    println("Текст поста: ${post2.text}")
    println(post1.comments.add(Comment(376, "Конец, конец. Концы в воду!")))
}