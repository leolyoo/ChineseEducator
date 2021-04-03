package leolyoo.chineseeducator

data class Word(
    val character: String = ERROR,
    val pronunciation: String = ERROR,
    val meaning: String = ERROR,
    val gif: Int = R.raw.gif_error
)