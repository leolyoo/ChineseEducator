package leolyoo.chineseeducator

class QuizViewModel(
    private var onChangeListener: (() -> Unit),
    private var onCheckAnswerListener: ((isCorrect: Boolean) -> Unit),
    private var onResultListener: ((isPassed: Boolean) -> Unit)
) {
    private var presentQuiz: Quiz = Quiz()

    val life: Int
        get() = QuizCookie.life
    val remaining: Int
        get() = if (QuizCookie.quizzes != null) QuizCookie.quizzes!!.size else -1
    var tmpQuestion: String = presentQuiz.question
    var tmpMeaning: String = presentQuiz.meaning
    var tmpChoices: MutableList<String> = presentQuiz.choices.toMutableList()

    var pointer = 1

    fun choose(position: Int) {
        val choice = tmpChoices[position]
        tmpChoices.removeAt(position)

        if (presentQuiz.type == Quiz.Type.ARRANGE) {
            tmpQuestion = tmpQuestion.replace(getNumberBlank(pointer), choice)
            pointer++
            change()
            if (tmpChoices.isEmpty()) {
                checkAnswer(tmpQuestion == presentQuiz.answer)
                reset()
            }
        } else
            checkAnswer(choice == presentQuiz.answer)
    }

    fun reset() {
        pointer = 1
        presentQuiz = QuizCookie.quiz
        tmpQuestion = presentQuiz.question
        tmpMeaning = presentQuiz.meaning
        tmpChoices = presentQuiz.choices.toMutableList()

        change()
    }

    private fun checkAnswer(isCorrect: Boolean) {
        onCheckAnswerListener.invoke(isCorrect)
        if (isCorrect) {
            val status = QuizCookie.next()
            if (status == QuizCookie.Status.OK) reset()
            else if (status == QuizCookie.Status.PASS) result(true)
        } else {
            if (QuizCookie.loseLife()) change()
            else result(false)
        }
    }

    private fun change() {
        onChangeListener.invoke()
    }

    private fun result(isPassed: Boolean) {
        onResultListener.invoke(isPassed)
    }
}