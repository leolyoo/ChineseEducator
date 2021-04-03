package leolyoo.chineseeducator

import android.app.Application

class App : Application() {

    init {
        INSTANCE = this
    }

    companion object {
        lateinit var INSTANCE: App

    }

    override fun onCreate() {
        super.onCreate()
        TTS.init(this)
    }

    override fun onTerminate() {
        TTS.destroy()
        PartCookie.destroy()
        QuizCookie.destroy()
        super.onTerminate()
    }
}