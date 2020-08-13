package ch.zhdk.tracking.config

import ch.bildspur.model.DataModel
import ch.bildspur.ui.properties.*
import ch.zhdk.tracking.TrackingApplication
import com.google.gson.annotations.Expose

class AppConfig {
    @Expose
    var input = InputConfig()

    @Expose
    var pipeline = PipelineConfig()

    @Expose
    var output = OutputConfig()

    @LabelParameter("Preview")
    private val outputLabel = ""

    @Expose
    @BooleanParameter("Production Mode")
    var productionMode = DataModel(false)

    @Expose
    @BooleanParameter("Display Processed")
    var displayProcessed = DataModel(true)

    @Expose
    @NumberParameter("Preview Width", " px")
    var previewWidth = DataModel(1280)

    @Expose
    @NumberParameter("Preview Height", " px")
    var previewHeight = DataModel(720)

    @ActionParameter("Input Frame", "Save", false)
    private val requestScreenshot = {
        TrackingApplication.saveFrameRequested = true
    }

    @ActionParameter("Pipeline", "Restart")
    private val restartPipeline = {
        TrackingApplication.requestPipelineRestart(true)
    }

    @LabelParameter("Information")
    private val infoLabel = ""

    @StringParameter("Message", isEditable = false)
    var message = DataModel("")

    @TextParameter("Error", isEditable = false, wordWrap = true)
    var errorMessage = DataModel("")
}