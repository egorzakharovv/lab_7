package component

import data.Lesson
import data.Student
import kotlinx.html.InputType
import kotlinx.html.id
import kotlinx.html.js.onChangeFunction
import kotlinx.html.js.onClickFunction
import kotlinx.html.onChange
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.events.Event
import react.*
import react.dom.*
import kotlin.browser.document

interface AddLessonProps : RProps {
    var lessons: Array<Lesson>
    var addFunc: (Event) -> Unit
}

val fAddLesson =
    functionalComponent<AddLessonProps> {
        h1 {
            +"Добавить предмет"
        }
        div {
            input(type = InputType.text) {
                attrs.id = "lesson-name"
            }
            button {
                +"Добавить"
                attrs.onClickFunction = it.addFunc
            }

        }
    }


fun RBuilder.addlesson(
    lessons: Array<Lesson>,
    addFunc: (Event) -> Unit
) = child(fAddLesson) {
    attrs.lessons = lessons
    attrs.addFunc = addFunc
}
