package ch.zhdk.tracking

import ch.bildspur.configuration.ConfigurationController
import ch.zhdk.tracking.config.AppConfig
import javafx.application.Platform
import javafx.embed.swing.JFXPanel
import javafx.stage.Stage


class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Main().startApplication(args)
        }
    }

    fun startApplication(args: Array<String>) {
        val configuration = ConfigurationController(Application.NAME, "zhdk", Application.URI_NAME)
        var appConfig = configuration.loadAppConfig()

        // use a fresh config while debugging
        // todo: remove this before release
        appConfig = AppConfig()

        // init javafx toolkit
        JFXPanel()

        // start configuration app
        Platform.runLater {
            val window = ConfigWindow(configuration, appConfig)
            val stage = Stage()
            window.start(stage)
        }

        // start main app
        val app = Application(appConfig)
        app.run()
    }
}