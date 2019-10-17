package ch.zhdk.tracking.config

import ch.bildspur.model.DataModel
import ch.bildspur.ui.properties.*
import ch.zhdk.tracking.pipeline.PipelineType
import com.google.gson.annotations.Expose

class PipelineConfig {
    @Expose
    var calibration = CalibrationConfig()

    @Expose
    @EnumParameter("Pipeline")
    var pipelineType = DataModel(PipelineType.Simple)

    @BooleanParameter("Enabled")
    var enabled = DataModel(true)

    @Expose
    @BooleanParameter("Annotate Output")
    var annotateOutput = DataModel(true)

    @Expose
    @BooleanParameter("Display Output")
    var displayOutput = DataModel(true)

    @LabelParameter("Information")
    val informationLabel = ""

    @StringParameter("Input Width", isEditable = false)
    var inputWidth = DataModel(1)

    @StringParameter("Input Height", isEditable = false)
    var inputHeight = DataModel(1)

    @StringParameter("Total Detected Objects", isEditable = false)
    var uniqueId = DataModel(0)

    @StringParameter("Detected Objects", isEditable = false)
    var actualObjectCount = DataModel(0)

    @StringParameter("Frame Time", isEditable = false)
    var frameTime = DataModel("- ms")

    @StringParameter("Processing Time", isEditable = false)
    var processingTime = DataModel("- ms")

    @LabelParameter("Detection")
    val detectionLabel = ""

    @Expose
    @SliderParameter("Threshold", 0.0, 255.0, 1.0)
    var threshold = DataModel(150.0)

    @Expose
    @BooleanParameter("Use OTSU")
    var useOTSUThreshold = DataModel(false)

    @Expose
    @BooleanParameter("Morphology Filter")
    var morphologyFilterEnabled = DataModel(true)

    @Expose
    @SliderParameter("Erode Size", 1.0, 10.0, 1.0, snap = true)
    var erodeSize = DataModel(4)

    @Expose
    @SliderParameter("Dilate Size", 1.0, 10.0, 1.0, snap = true)
    var dilateSize = DataModel(4)

    @Expose
    @BooleanParameter("Detect Orientation")
    var detectOrientation = DataModel(true)

    @LabelParameter("Tracking")
    val trackingLabel = ""

    @Expose
    @SliderParameter("Max Delta", 0.0, 200.0, 1.0)
    var maxDelta = DataModel(40.0)

    @LabelParameter("Identification")
    private val identificationLabel = ""

    @Expose
    @BooleanParameter("Identification Enabled")
    var identificationEnabled = DataModel(true)

    @Expose
    @NumberParameter("Min LifeTime", "frames")
    var minLifeTime = DataModel(10)

    @Expose
    @SliderParameter("Samples", 0.0, 300.0, 1.0, snap = true)
    // todo: could be calculated from frame rate and protocol speed
    var sampleCount = DataModel(90)

    @Expose
    @SliderParameter("Threshold Margin", 0.0, 1.0, 0.05, snap = true)
    var thresholdMarginFactor = DataModel(1.0)
}