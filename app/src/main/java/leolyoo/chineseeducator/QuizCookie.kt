package leolyoo.chineseeducator

object QuizCookie {
    enum class Status {
        OK, ERROR, PASS
    }

    var quizzes: MutableList<Quiz>? = null
    var life = 0
    var stage = 0
    var isExam = false

    val quiz: Quiz
        get() {
            if (quizzes != null && quizzes!!.isNotEmpty()) {
                return quizzes!![0]
            }
            return Quiz()
        }

    fun loseLife(): Boolean {
        life--
        return life > 0
    }

    fun next(): Status {
        return if (quizzes != null) {
            if (quizzes!!.size > 1) {
                quizzes!!.removeAt(0)
                Status.OK
            } else {
                Status.PASS
            }
        } else {
            Status.ERROR
        }
    }

    fun initWord() {
        isExam = false
        life = 3
        quizzes = createWordQuizzes(PartCookie.requestWords())
    }

    fun initBlank() {
        isExam = false
        life = 3
        quizzes = createBlankQuizzes(PartCookie.requestSentences(), PartCookie.requestWords())
    }

    fun initArrange() {
        isExam = false
        life = 3
        quizzes = createArrangeQuizzes(PartCookie.requestSentences(), PartCookie.requestWords())
    }

    fun initExam(stage: Int) {
        isExam = true
        this.stage = stage
        life = 5
        quizzes = mutableListOf()
        quizzes!!.apply {
            val words = loadWords(stage, 1).plus(loadWords(stage, 2))
            val sentences = loadSentences(stage, 1).plus(loadSentences(stage, 2))
            addAll(createWordQuizzes(words))
            addAll(createBlankQuizzes(sentences, words))
            addAll(createArrangeQuizzes(sentences, words))
        }
    }

    fun destroy() {
        if (quizzes != null) {
            quizzes = null
        }
    }
}