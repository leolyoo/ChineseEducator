package leolyoo.chineseeducator

object PartCookie {
    var sentences: List<Sentence>? = null
    var words: List<Word>? = null

    fun init(stage: Int, part: Int) {
        sentences = loadSentences(stage, part)
        words = loadWords(stage, part)
    }

    fun requestSentences() = if (sentences != null) sentences!! else listOf()
    fun requestWords() = if (words != null) words!! else listOf()

    fun destroy() {
        if (sentences != null) {
            sentences = null
        }
        if (words != null) {
            words = null
        }
    }
}