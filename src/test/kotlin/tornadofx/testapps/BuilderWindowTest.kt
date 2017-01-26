package tornadofx.testapps

import javafx.application.Platform
import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import javafx.stage.StageStyle.UNDECORATED
import tornadofx.*

class BuilderWindowTestApp : App(DangerButtonView::class)

class DangerButtonView : View("Do not click the button!") {
    override val root = stackpane {
        setPrefSize(400.0, 200.0)
        button("Don't click me") {
            style {
                fontSize = 20.px
                fontWeight = FontWeight.BOLD
                textFill = Color.RED
            }
            setOnAction {
                builderWindow("What do you want?", stageStyle = UNDECORATED, owner = primaryStage) {
                    vbox(10) {
                        style {
                            padding = box(20.px)
                            borderColor += box(Color.ORANGE)
                            borderWidth += box(2.px)
                        }

                        label("So, you clicked it anyway.. What do you want?") {
                            style {
                                fontWeight = FontWeight.BOLD
                            }
                        }

                        hbox(10) {
                            button("Tell them you clicked") {
                                setOnAction {
                                    this@DangerButtonView.title = "It's not dangerous to click the button :)"
                                    closeModal()
                                }
                            }
                            button("Close app") {
                                setOnAction {
                                    Platform.exit()
                                }
                            }
                            button("Cancel") {
                                setOnAction {
                                    closeModal()
                                }
                            }
                        }
                    }
                }
            }
        }
    }

}