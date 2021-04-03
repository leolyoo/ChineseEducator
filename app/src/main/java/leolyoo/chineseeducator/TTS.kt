package leolyoo.chineseeducator

import android.content.Context
import android.content.Intent
import android.os.Build
import android.speech.tts.TextToSpeech
import android.widget.Toast
import java.util.*

object TTS {
    var tts: TextToSpeech? = null

    fun init(context: Context) {
        if (tts == null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
                tts = TextToSpeech(context) {
                    if (it == TextToSpeech.SUCCESS) {
                        val result = tts?.setLanguage(Locale.CHINA)
                        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                            Toast.makeText(context, "지원하지 않는 언어입니다.", Toast.LENGTH_LONG).show()
                            val installIntent = Intent()
                            installIntent.action = TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA
                            installIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            context.startActivity(installIntent)
                        } else {
                            Toast.makeText(context, "TTS 초기화 성공", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(context, "TTS 초기화 실패", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    fun destroy() {
        if (tts != null) {
            tts?.stop()
            tts?.shutdown()
            tts = null
        }
    }

    fun speech(text: String) {
        if (tts != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, null)
            }
        }
    }
}