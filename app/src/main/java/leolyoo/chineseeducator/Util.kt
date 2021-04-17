package leolyoo.chineseeducator

import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import java.text.SimpleDateFormat
import java.util.*

const val EXTRA_GIF = "leolyoo.chineseeducator.GIF"

const val ERROR = ""
const val BLANK = "[    ]"

fun getDate(): String {
    return SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.KOREA).format(Date()).toString()
}

fun getLargeText(text: String) =
    SpannableStringBuilder(text).apply { setSpan(RelativeSizeSpan(3f), 0, text.length, 0) }

fun getBiggerText(text: String) =
    SpannableStringBuilder(text).apply { setSpan(RelativeSizeSpan(1.3f), 0, text.length, 0) }

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
        2 -> when (part) {
            1 -> return listOf(
                Sentence(
                    "您喝咖啡还是喝绿茶？",
                    "nín hē kāfēi háishì hē lǜchá?",
                    "당신은 커피를 마시겠습니까? 아니면 녹차를 마시겠습니까?"
                ),
                Sentence("我喝咖啡。", "wǒ hē kāfēi.", "저는 커피를 마시겠습니다.")
            )
            2 -> return listOf(
                Sentence("我喝美式咖啡 。", "wǒ hē měishì kāfēi.", "저는 아메리카노를 마시겠습니다."),
                Sentence("我要两杯红茶。", "Wǒ yào liǎng bēi hóngchá.", "저는 홍차 2잔을 원합니다.")
            )
        }
        3 -> when (part) {
            1 -> return listOf(
                Sentence("要加糖和奶吗？", "yào jiā táng hé nǎi ma?", "설탕, 크림을 넣으시겠습니까?"),
                Sentence("我只要糖。", "wǒ zhǐ yào táng.", "저는 설탕만 필요합니다.")
            )
            2 -> return listOf(
                Sentence("要加冰块吗？", "yào jiā bīng kuài ma?", "얼음을 넣으시겠습니까?"),
                Sentence("我不要加冰块。", "wǒ búyào jiā bīng kuài.", "저는 얼음을 넣는 것을 원하지 않습니다."),
                Sentence("请慢用.", "qǐng màn yòng.", "맛있게 드십시오.")
            )
        }
        4 -> when (part) {
            1 -> return listOf(
                Sentence("今天有两种餐食。", "jīn tiān yǒu liǎng zhǒng cān shí.", "오늘은 두 종류의 식사가 있습니다."),
                Sentence("您喜欢吃哪种？", "nín xǐ huān chī nǎ zhǒng ？", "어떤 종류를 드시겠습니까?")
            )
            2 -> return listOf(
                Sentence("我吃牛肉盖饭。", "wǒ chī niúròu gài fàn.", "저는 소고기 덮밥을 먹겠습니다."),
                Sentence("太淡了。", "tài dàn le.", "너무 싱겁습니다."),
                Sentence("请给我盐.", "qǐng gěi wǒ yán.", "소금을 주십시오.")
            )
        }
        5 -> when (part) {
            1 -> return listOf(
                Sentence("牛肉盖饭没有了。", "niúròu gài fàn méiyǒule", "소고기 덮밥이 소진되었습니다."),
                Sentence("吃鸡肉盖饭怎么样?", "chī jīròu gài fàn zěnme yàng?", "닭고기 덮밥을 드시는 것은 어떠십니까?")
            )
            2 -> return listOf(
                Sentence("吃好了吗？", "chī hǎole ma?", "다 드셨습니까?"),
                Sentence("把餐盘可以拿走吗?", "bǎ cān pán kěyǐ ná zǒu ma?", "가져가도 되겠습니까?")
            )
        }
        6 -> when (part) {
            1 -> return listOf(
                Sentence("你预订过特殊餐吗?", "nǐ yùdìng guò tèshūcān ma?", "스페셜 밀을 주문하신 적이 있습니까?"),
                Sentence("这是您预订的婴儿餐。", "zhè shì nín yùdìng de yīng'ér cān.", "당신이 주문하신 베이비밀입니다.")
            )
            2 -> return listOf(
                Sentence("这是您预订的儿童餐。", "zhè shì nín yùdìng de értóng cān.", "이것은 당신이 주문한 아동식입니다."),
                Sentence("还需要什么吗？", "hái xūyào shénme ma?", "더 필요 한 것이 있습니까?")
            )
        }
        7 -> when (part) {
            1 -> return listOf(
                Sentence("我有点儿冷。", "wǒ yǒudiǎnr lěng.", "저는 조금 춥습니다."),
                Sentence("请给我毛毯。", "qǐng gěi wǒ máotǎn.", "담요를 주세요.")
            )
            2 -> return listOf(
                Sentence("耳机好像坏了。", "ěrjī hǎoxiàng huài le", "이어폰이 고장난 것 같습니다."),
                Sentence("我马上给您换新的.", "wǒ mǎshàng gěi nín huàn xīn de.", "제가 곧 새것을 바꾸어 드리겠습니다.")
            )
        }
        8 -> when (part) {
            1 -> return listOf(
                Sentence("这是入境卡。", "zhè shì rù jìng kǎ。", "이것은 입국신고서입니다."),
                Sentence(
                    "每个人都要填写1张入境卡。",
                    "měi ge rén dōu yào tián xiě yì zhāng rù jìng kǎ 。",
                    "모든 사람이 1장의 입국신고서를 작성하셔야 합니다."
                )
            )
            2 -> return listOf(
                Sentence("这是海关申报单。", "zhè shì hǎi guān shēn bào dān 。", "이것은 세관신고서입니다."),
                Sentence("一家人填写一张就行。", "yì jiā rén tiánxiě yì zhāng jiùxíng.", "가족당 1장을 작성하시면 됩니다.")
            )
        }
        9 -> when (part) {
            1 -> return listOf(
                Sentence("我想买口红。", "wǒ xiǎng mǎi kǒuhóng.", "저는 립스틱을 사고 싶습니다."),
                Sentence(
                    "您要买哪种颜色的口红?",
                    "nín yào mǎi nǎ zhǒng yánsè de kǒuhóng?",
                    "어떤 색상의 립스틱을 구매하시겠습니까?"
                )
            )
            2 -> return listOf(
                Sentence(
                    "我想介绍给您这瓶香水。",
                    "wǒ xiǎng jièshào gěi nín zhè píng xiāngshuǐ.",
                    "저는 이 향수를 추천하고 싶습니다."
                ),
                Sentence(
                    "这瓶香水受到很多人的欢迎。",
                    "zhè píng xiāng shuǐ shòu dào hěn duō rén de huān yíng 。",
                    "이 향수는 많은 사람들에게 인기가 있습니다."
                )
            )
        }
        10 -> when (part) {
            1 -> return listOf(
                Sentence("人民币多少钱？", "rénmínbì duōshǎo qián?", "인민폐로 얼마입니까?"),
                Sentence("这是100块人民币。", "zhè shì yì bǎi kuài rénmínbì.", "이것은 인민폐 100위안입니다.")
            )
            2 -> return listOf(
                Sentence("今天的汇率是多少？", "jīntiān de huìlǜ shì duōshǎo?", "오늘 환율이 얼마입니까?"),
                Sentence(
                    "1美元等于1200韩币。",
                    "yì měiyuán děngyú yì qiān èr bǎi hánbì.",
                    "1달러는 한화로 1200원입니다.。Yì měiyuán děngyú yì qiān èr bǎi hánbì."
                )
            )
        }
        11 -> when (part) {
            1 -> return listOf(
                Sentence("想怎么结算呢？", "xiǎng zěnme jiésuàn ne?", "어떻게 계산하시겠습니까?"),
                Sentence(
                    "我想用人民币结算。",
                    "wǒ xiǎng yòng rénmínbì jiésuàn.",
                    "인민폐로 계산하겠습니다.Wǒ xiǎng yòng rénmínbì jiésuàn."
                )
            )
            2 -> return listOf(
                Sentence("我想用信用卡结算。", "wǒ xiǎng yòng xìn yòng kǎ jiésuàn.", "저는 신용카드로 계산하려고 합니다.")
            )
        }
        12 -> when (part) {
            1 -> return listOf(
                Sentence(
                    "请给我您的护照和信用卡。",
                    "qǐng gěi wǒ nín de hù zhào hé xìn yòng kǎ 。请给我您的护照和信用卡。",
                    "여권과 카드를 주시겠습니까?"
                ),
                Sentence("请在这里签名。", "qǐng zài zhèlǐ qiānmíng.", "이곳에 서명해 주십시오.")
            )
            2 -> return listOf(
                Sentence(
                    "这是零钱20块人民币。",
                    "zhè shì líng qián èr shí kuài rén mín bì 。",
                    "이것은 잔돈 20위안입니다."
                ),
                Sentence("请您确认一下。", "qǐng nín quèrèn yíxià.", "확인해 주십시오.")
            )
        }
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
        2 -> when (part) {
            1 -> return listOf(
                Word("喝", "hē", "마시다", R.raw.gif_s02_p01_01_he),
                Word("咖啡", "kāfēi", "커피", R.raw.gif_s02_p01_02_kafei),
                Word("还是", "háishì", "~아니면", R.raw.gif_s02_p01_03_haishi),
                Word("绿茶", "lǜchá", "녹차", R.raw.gif_s02_p01_04_lucha)
            )
            2 -> return listOf(
                Word("美式咖啡", "měishì kāfēi", "아메리카노", R.raw.gif_s02_p02_01_meishikafei),
                Word("要", "yào", "필요하다, 원하다", R.raw.gif_s02_p02_02_yao),
                Word("红茶", "hóngchá", "홍차", R.raw.gif_s02_p02_03_hongcha),
                Word("奶茶", "nǎichá", "밀크티", R.raw.gif_s02_p02_04_naicha),
                Word("拿铁", "ná tiě", "라떼", R.raw.gif_s02_p02_05_natie),
                Word("杯", "bēi", "잔, 컵", R.raw.gif_s02_p02_06_bei),
                Word("本", "běn", "권", R.raw.gif_s02_p02_07_ben),
                Word("本子", "běn zi", "노트", R.raw.gif_s02_p02_08_benzi),
                Word("件", "jiàn", "벌", R.raw.gif_s02_p02_09_jian),
                Word("衣服", "yīfú", "옷", R.raw.gif_s02_p02_10_yifu)
            )
        }
        3 -> when (part) {
            1 -> return listOf(
                Word("要", "yào", "원하다", R.raw.gif_s03_p01_01_yao),
                Word("加", "jiā", "더하다", R.raw.gif_s03_p01_02_jia),
                Word("糖", "táng", "설탕", R.raw.gif_s03_p01_03_tang),
                Word("和", "hé", "~와", R.raw.gif_s03_p01_04_he),
                Word("奶", "nǎi", "크림, 우유", R.raw.gif_s03_p01_05_nai),
                Word("只", "zhǐ", "단지", R.raw.gif_s03_p01_06_zhi)
            )
            2 -> return listOf(
                Word("要", "yào", "원하다", R.raw.gif_s03_p02_01_yao),
                Word("加", "jiā", "더하다", R.raw.gif_s03_p02_02_jia),
                Word("不", "bù", "부정의 표시", R.raw.gif_s03_p02_03_bu),
                Word("冰块", "bīng kuài", "얼음", R.raw.gif_s03_p02_04_bingkuai),
                Word("柠檬", "níngméng", "레몬", R.raw.gif_s03_p02_05_ningmeng),
                Word("牛奶", "niúnǎi", "우유", R.raw.gif_s03_p02_06_niunai),
                Word("请", "qǐng", "청하다", R.raw.gif_s03_p02_07_qing),
                Word("慢", "màn", "느리다", R.raw.gif_s03_p02_08_man),
                Word("用", "yòng", "드시다", R.raw.gif_s03_p02_09_yong)
            )
        }
        4 -> when (part) {
            1 -> return listOf(
                Word("今天", "Jīn tiān", "오늘", R.raw.gif_s04_p01_01_jintian),
                Word("有", "yǒu", "있다", R.raw.gif_s04_p01_02_you),
                Word("两", "liǎng", "둘", R.raw.gif_s04_p01_03_liang),
                Word("种", "zhǒng", "종류", R.raw.gif_s04_p01_04_zhong),
                Word("餐食", "cān shí", "식사", R.raw.gif_s04_p01_05_canshi),
                Word("喜欢", "xǐ huān", "좋아하다", R.raw.gif_s04_p01_06_xihuan),
                Word("哪", "nǎ", "어느", R.raw.gif_s04_p01_07_na)
            )
            2 -> return listOf(
                Word("牛肉", "niúròu", "소고기", R.raw.gif_s04_p02_01_niurou),
                Word("盖饭", "gài fàn", "덮밥", R.raw.gif_s04_p02_02_gaifan),
                Word("太…了", "tài…le", "너무 ~하다", R.raw.gif_s04_p02_03_taile),
                Word("淡", "dàn", "싱겁다", R.raw.gif_s04_p02_04_dan),
                Word("给", "gěi", "주다", R.raw.gif_s04_p02_05_gei),
                Word("盐", "yán", "소금", R.raw.gif_s04_p02_06_yan),
                Word("黄油", "huángyóu", "버터", R.raw.gif_s04_p02_07_huangyou),
                Word("胡椒", "hújiāo", "후추", R.raw.gif_s04_p02_08_hujiao)
            )
        }
        5 -> when (part) {
            1 -> return listOf(
                Word("牛肉盖饭", "niúròu gàifàn", "소고기 덮밥", R.raw.gif_s05_p01_01_niurougaifan),
                Word("没有", "méiyǒu", "없다", R.raw.gif_s05_p01_02_meiyou),
                Word("了", "le", "변화", R.raw.gif_s05_p01_03_le),
                Word("鸡肉", "jīròu", "닭고기", R.raw.gif_s05_p01_04_jirou),
                Word("怎么样", "zěnme yàng", "어떠한가", R.raw.gif_s05_p01_05_zenmeyang)
            )
            2 -> return listOf(
                Word("好了", "hǎo le", "다 했다", R.raw.gif_s05_p02_01_haole),
                Word("把", "bǎ", "전치", R.raw.gif_s05_p02_02_ba),
                Word("餐盘", "cān pán", "식사 트레이", R.raw.gif_s05_p02_03_canpan),
                Word("可以", "kěyǐ", "가능하다", R.raw.gif_s05_p02_04_keyi),
                Word("拿走", "ná zǒu", "가져가다", R.raw.gif_s05_p02_05_nazou)
            )
        }
        6 -> when (part) {
            1 -> return listOf(
                Word("预订", "yùdìng", "예약하다", R.raw.gif_s06_p01_01_yuding),
                Word("过", "guò", "경험", R.raw.gif_s06_p01_02_guo),
                Word("特殊餐", "tèshūcān", "special meal", R.raw.gif_s06_p01_03_teshucan),
                Word("婴儿餐", "yīng'ér cān", "BBML", R.raw.gif_s06_p01_04_yingercan)
            )
            2 -> return listOf(
                Word("预订", "yùdìng", "예약하다", R.raw.gif_s06_p02_01_yuding),
                Word("儿童餐", "értóng cān", "Child Meal", R.raw.gif_s06_p02_02_ertongcan),
                Word("素食", "sù shí", "Vegetarian Meal", R.raw.gif_s06_p02_03_sushi),
                Word("溃疡餐", "kuì yáng cān", "Bland Meal", R.raw.gif_s06_p02_04_kuiyangcan),
                Word("穆斯林餐", "mù sī lín cān", "Muslim Meal", R.raw.gif_s06_p02_05_musilincan),
                Word("犹太餐", "yóu tài cān", "Kosher Meal", R.raw.gif_s06_p02_06_youtaican),
                Word("印度餐", "yìn dù cān", "Hindu Meal", R.raw.gif_s06_p02_07_yinducan),
                Word("还", "hái", "또, 더", R.raw.gif_s06_p02_08_hai),
                Word("需要", "xūyào", "필요하다", R.raw.gif_s06_p02_09_xuyao),
                Word("什么", "shénme", "무엇", R.raw.gif_s06_p02_10_shenme)
            )
        }
        7 -> when (part) {
            1 -> return listOf(
                Word("有点儿", "yǒudiǎnr", "조금", R.raw.gif_s07_p01_01_youdianr),
                Word("冷", "lěng", "춥다", R.raw.gif_s07_p01_02_leng),
                Word("给", "gěi", "~에게,주다", R.raw.gif_s07_p01_03_gei),
                Word("毛毯", "máotǎn", "담요", R.raw.gif_s07_p01_04_maotan),
                Word("头疼", "tóuténg", "머리가 아프다", R.raw.gif_s07_p01_05_touteng),
                Word("止疼片", "zhǐ téng piàn", "진통제", R.raw.gif_s07_p01_06_zhitengpian),
                Word("拖鞋", "tuōxié", "슬리퍼", R.raw.gif_s07_p01_07_tuoxie),
                Word("眼罩", "yǎnzhào", "안대", R.raw.gif_s07_p01_08_yanzhao)
            )
            2 -> return listOf(
                Word("耳机", "ěrjī", "이어폰", R.raw.gif_s07_p02_01_erji),
                Word("好像", "hǎoxiàng", "~인 것 같다", R.raw.gif_s07_p02_02_haoxiang),
                Word("坏", "huài", "고장나다", R.raw.gif_s07_p02_03_huai),
                Word("马上", "mǎshàng", "곧", R.raw.gif_s07_p02_04_mashang),
                Word("换", "huàn", "바꾸다", R.raw.gif_s07_p02_05_huan)
            )
        }
        8 -> when (part) {
            1 -> return listOf(
                Word("入境卡", "rù jìng kǎ", "입국신고서", R.raw.gif_s08_p01_01_rujingka),
                Word("每个人", "měi ge rén", "매 사람", R.raw.gif_s08_p01_02_meigeren),
                Word("都", "dōu", "모두", R.raw.gif_s08_p01_03_dou),
                Word("要", "yào", "~해야한다", R.raw.gif_s08_p01_04_yao),
                Word("填写", "tián xiě", "작성하다", R.raw.gif_s08_p01_05_tianxie),
                Word("张", "zhāng", "장", R.raw.gif_s08_p01_06_zhang),
                Word("检疫申报单", "jiǎnyì shēnbào dān", "검역신고서", R.raw.gif_s08_p01_07_jianyishenbaodan)
            )
            2 -> return listOf(
                Word(
                    "海关申报单",
                    "hǎi guān shēn bào dān",
                    "세관신고서",
                    R.raw.gif_s08_p02_01_haiguanshenbaodan
                ),
                Word("家人", "jiā rén", "식구", R.raw.gif_s08_p02_02_jiaren),
                Word("填写", "tián xiě", "작성하다", R.raw.gif_s08_p02_03_tianxie),
                Word("张", "zhāng", "장", R.raw.gif_s08_p02_04_zhang),
                Word("就行", "jiù xíng", "~하면 된다", R.raw.gif_s08_p02_05_jiuxing)
            )
        }
        9 -> when (part) {
            1 -> return listOf(
                Word("想", "xiǎng", "~하고싶다", R.raw.gif_s09_p01_01_xiang),
                Word("买", "mǎi", "사다", R.raw.gif_s09_p01_02_mai),
                Word("口红", "kǒuhóng", "립스틱", R.raw.gif_s09_p01_03_kouhong),
                Word("要", "yào", "~하려고 하다", R.raw.gif_s09_p01_04_yao),
                Word("哪", "nǎ", "어느", R.raw.gif_s09_p01_05_na),
                Word("种", "zhǒng", "종류", R.raw.gif_s09_p01_06_zhong),
                Word("颜色", "yánsè", "색상", R.raw.gif_s09_p01_07_yanse)
            )
            2 -> return listOf(
                Word("想", "xiǎng", "~하고싶다", R.raw.gif_s09_p02_01_xiang),
                Word("介绍", "jièshào", "소개하다", R.raw.gif_s09_p02_02_jieshao),
                Word("给", "gěi", "~에게", R.raw.gif_s09_p02_03_gei),
                Word("瓶", "píng", "병", R.raw.gif_s09_p02_04_ping),
                Word("香水", "xiāng shuǐ", "향수", R.raw.gif_s09_p02_05_xiangshui),
                Word("欢迎", "huān yíng", "환영", R.raw.gif_s09_p02_06_huanying),
                Word("收到", "shòu dào", "받다", R.raw.gif_s09_p02_07_shoudao)
            )
        }
        10 -> when (part) {
            1 -> return listOf(
                Word("人民币", "Rénmínbì", "인민폐", R.raw.gif_s10_p01_01_renminbi),
                Word("多少", "duōshǎo", "얼마", R.raw.gif_s10_p01_02_duoshao),
                Word("钱", "qián", "돈", R.raw.gif_s10_p01_03_qian),
                Word("块", "kuài", "화폐단위 (소수점 윗자리)", R.raw.gif_s10_p01_04_kuai),
                Word("毛", "máo", "화폐단위 (소수점 첫째자리)", R.raw.gif_s10_p01_05_mao),
                Word("分", "fēn", "화폐단위 (소수점 둘째자리)", R.raw.gif_s10_p01_06_fen),
                Word("百", "bǎi", "백", R.raw.gif_s10_p01_07_bai),
                Word("千", "qiān", "천", R.raw.gif_s10_p01_08_qian),
                Word("万", "wàn", "만", R.raw.gif_s10_p01_09_wan)
            )
            2 -> return listOf(
                Word("汇率", "huìlǜ", "환율", R.raw.gif_s10_p02_01_huilu),
                Word("多少", "duōshǎo", "얼마", R.raw.gif_s10_p02_02_duoshao),
                Word("美元", "měiyuán", "달러", R.raw.gif_s10_p02_03_meiyuan),
                Word("等于", "děngyú", "해당하다", R.raw.gif_s10_p02_04_dengyu),
                Word("韩币", "hánbì", "한화", R.raw.gif_s10_p02_05_hanbi)
            )
        }
        11 -> when (part) {
            1 -> return listOf(
                Word("想", "xiǎng", "~하려하다", R.raw.gif_s11_p01_01_xiang),
                Word("怎么", "zěnme", "어떻게", R.raw.gif_s11_p01_02_zenme),
                Word("用", "yòng", "사용하다", R.raw.gif_s11_p01_03_yong),
                Word("人民币", "rénmínbì", "인민폐", R.raw.gif_s11_p01_04_renminbi)
            )
            2 -> return listOf(
                Word("想", "xiǎng", "~하려 하다", R.raw.gif_s11_p02_01_xiang),
                Word("用", "yòng", "사용하다", R.raw.gif_s11_p02_02_yong),
                Word("信用卡", "xìn yòng kǎ", "신용카드", R.raw.gif_s11_p02_03_xinyongka),
                Word("韩币", "hán bì", "원화", R.raw.gif_s11_p02_04_hanbi),
                Word("美元", "měi yuán", "달러", R.raw.gif_s11_p02_05_meiyuan),
                Word("欧元", "ōu yuán", "유로화", R.raw.gif_s11_p02_06_ouyuan),
                Word("日元", "rì yuán", "엔화", R.raw.gif_s11_p02_07_riyuan),
                Word("现金", "xiàn jīn", "현금", R.raw.gif_s11_p02_08_xianjin),
                Word("结算", "jiésuàn", "계산하다", R.raw.gif_s11_p02_09_jiesuan)
            )
        }
        12 -> when (part) {
            1 -> return listOf(
                Word("给", "gěi", "주다", R.raw.gif_s12_p01_01_gei),
                Word("护照", "hù zhào", "여권", R.raw.gif_s12_p01_02_huzhao),
                Word("和", "hé", "~와", R.raw.gif_s12_p01_03_he),
                Word("信用卡", "xìn yòng kǎ", "신용카드", R.raw.gif_s12_p01_04_xinyongka),
                Word("在", "zài", "~에", R.raw.gif_s12_p01_05_zai),
                Word("这里", "zhèlǐ", "이곳", R.raw.gif_s12_p01_06_zheli),
                Word("签名", "qiānmíng", "서명하다", R.raw.gif_s12_p01_07_qianming)
            )
            2 -> return listOf(
                Word("零钱", "líng qián", "잔돈", R.raw.gif_s12_p02_01_lingqian),
                Word("人民币", "rén mín bì", "인민폐", R.raw.gif_s12_p02_02_renminbi),
                Word("韩币", "hán bì", "원화", R.raw.gif_s12_p02_03_hanbi),
                Word("美元", "měi yuán", "달러", R.raw.gif_s12_p02_04_meiyuan),
                Word("确认", "quèrèn", "확인하다", R.raw.gif_s12_p02_05_queren),
                Word("一下", "yíxià", "한번 ~하다", R.raw.gif_s12_p02_06_yixia)
            )
        }
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
