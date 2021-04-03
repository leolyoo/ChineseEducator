package leolyoo.chineseeducator

import java.text.SimpleDateFormat
import java.util.*

const val EXTRA_GIF = "leolyoo.chineseeducator.GIF"

const val ERROR = ""
const val BLANK = "[    ]"

fun getDate(): String {
    return SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.KOREA).format(Date()).toString()
}

fun getStagePrefKey(stage: Int) = "leolyoo.chineseeducator.STAGE$stage"

fun getNumberBlank(value: Int) = "[ $value ]"

fun loadSentences(stage: Int, part: Int): List<Sentence> {
    when (stage) {
        1 -> when (part) {
            1 -> return listOf(
                Sentence("您喝什么饮料？", "nín hē shénme yǐnliào?", "무슨 음료를 마시겠습니까?"),
                Sentence("我喝橙汁。", "wǒ hē chéngzhī.", "저는 오렌지주스를 마시겠습니다.")
            )
            2 -> return listOf(
                Sentence(
                    "有橙汁，苹果汁和芒果汁。",
                    "yǒu chéngzhī, píngguǒ zhī hé mángguǒ zhī.",
                    "오렌지주스, 사과주스와 망고주스가 있습니다."
                ),
                Sentence("我喝苹果汁。", "wǒ hē píngguǒzhī.", "저는 사과주스를 마시겠습니다.")
            )
        }
//        2 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        3 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        4 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        5 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        6 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        7 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        8 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        9 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        10 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        11 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        12 -> when (part) {
//            1 -> return
//            2 -> return
//        }
    }
    return listOf(Sentence())
}

fun loadWords(stage: Int, part: Int): List<Word> {
    when (stage) {
        1 -> when (part) {
            1 -> return listOf(
                Word("您", "nín", "당신", R.raw.gif_s01_p01_01_nin),
                Word("喝", "hē", "마시다", R.raw.gif_s01_p01_02_he),
                Word("什么", "shénme", "무엇", R.raw.gif_s01_p01_03_shenme),
                Word("饮料", "yǐnliào", "음료", R.raw.gif_s01_p01_04_yinliao),
                Word("橙汁", "chéngzhī", "오렌지 주스", R.raw.gif_s01_p01_05_chengzhi)
            )
            2 -> return listOf(
                Word("有", "yǒu", "있다", R.raw.gif_s01_p02_01_you),
                Word("可乐", "kě lè", "콜라", R.raw.gif_s01_p02_02_kele),
                Word("雪碧", "xuě bì", "사이다", R.raw.gif_s01_p02_03_xuebi),
                Word("矿泉水", "kuàng quán shuǐ", "물", R.raw.gif_s01_p02_04_kuangquanshui),
                Word("橙汁", "chéng zhī", "오렌지 주스", R.raw.gif_s01_p02_05_chengzhi),
                Word("苹果汁", "píng guǒ zhī", "사과 주스", R.raw.gif_s01_p02_06_pingguozhi),
                Word("芒果汁", "mángguǒ zhī", "망고 주스", R.raw.gif_s01_p02_07_mangguozhi),
                Word("番茄汁", "fān qié zhī", "토마토 주스", R.raw.gif_s01_p02_08_fanqiezhi),
                Word("啤酒", "pí jiǔ", "맥주", R.raw.gif_s01_p02_09_pijiu),
                Word("葡萄酒", "pú táo jiǔ", "와인", R.raw.gif_s01_p02_10_putaojiu)

            )
        }
//        2 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        3 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        4 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        5 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        6 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        7 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        8 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        9 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        10 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        11 -> when (part) {
//            1 -> return
//            2 -> return
//        }
//        12 -> when (part) {
//            1 -> return
//            2 -> return
//        }
    }
    return listOf(Word())
}

fun createWordQuizzes(words: List<Word>): MutableList<Quiz> {
    val wordQuizzes = mutableListOf<Quiz>()

    for (answer in words) {
        val list = words.filterNot { it.meaning == answer.meaning }.shuffled()

        // 주어진 한자의 뜻 맞추기
        var choices = mutableListOf<String>()
        list.map { it.meaning }.distinct().forEach {
            if (choices.size < 3)
                choices.add(it)
        }
        choices.add(answer.meaning)
        while (choices.size < 4)
            choices.add(ERROR)
        choices.shuffle()

        wordQuizzes.add(
            Quiz(
                type = Quiz.Type.WORD,
                question = answer.character,
                answer = answer.meaning,
                choices = choices
            )
        )

        // 주어진 뜻을 가진 한자 맞추기
        choices = mutableListOf()
        list.map { it.character }.distinct().forEach {
            if (choices.size < 3)
                choices.add(it)
        }
        choices.add(answer.character)
        while (choices.size < 4)
            choices.add(ERROR)
        choices.shuffle()

        wordQuizzes.add(
            Quiz(
                type = Quiz.Type.WORD,
                question = answer.meaning,
                answer = answer.character,
                choices = choices
            )
        )
    }

    wordQuizzes.shuffle()
    while (wordQuizzes.size > 10)
        wordQuizzes.removeAt(0)

    return wordQuizzes
}

fun createBlankQuizzes(sentences: List<Sentence>, words: List<Word>): MutableList<Quiz> {
    val blankQuizzes = mutableListOf<Quiz>()

    val wordCharacters = words.map { it.character }
    wordCharacters.forEach { word ->
        sentences.forEach { sentence ->
            if (sentence.character.contains(word)) {
                val choices =
                    wordCharacters.filterNot { it == word }.shuffled().take(3).plus(word).shuffled()
                blankQuizzes.add(
                    Quiz(
                        type = Quiz.Type.BLANK,
                        question = sentence.character.replace(word, BLANK),
                        meaning = sentence.meaning,
                        answer = word,
                        choices = choices
                    )
                )
            }
        }
    }
    blankQuizzes.shuffle()
    while (blankQuizzes.size > 10)
        blankQuizzes.removeAt(0)

    return blankQuizzes
}

fun createArrangeQuizzes(sentences: List<Sentence>, words: List<Word>): MutableList<Quiz> {
    val arrangeQuizzes = mutableListOf<Quiz>()

    for (sentence in sentences) {
        var question = sentence.character
        var string = question
        val map = mutableMapOf<Int, String>()
        for (word in words) {
            val character = word.character
            if (string.contains(character)) {
                val key = question.indexOf(character)
                map[key] = character
                string = string.replace(character, BLANK)
            }
        }
        val choices = mutableListOf<String>()
        var count = 1
        map.toSortedMap().values.toList().forEach {
            question = question.replace(it, getNumberBlank(count))
            choices.add(count - 1, it)
            count++
        }

        arrangeQuizzes.add(
            Quiz(
                type = Quiz.Type.ARRANGE,
                question = question,
                meaning = sentence.meaning,
                answer = sentence.character,
                choices = choices.shuffled().toList()
            )
        )
    }
    arrangeQuizzes.shuffle()
    while (arrangeQuizzes.size > 10)
        arrangeQuizzes.removeAt(0)

    return arrangeQuizzes
}
