package leolyoo.chineseeducator

data class Quiz(
    val type: Type = Type.ERROR,
    val question: String = ERROR,
    val meaning: String = ERROR,
    val answer: String = ERROR,
    val choices: List<String> = listOf(ERROR)
) {
    enum class Type {
        WORD, BLANK, ARRANGE, ERROR
    }
}