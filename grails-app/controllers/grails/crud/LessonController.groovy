package grails.crud

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class LessonController {

    LessonService lessonService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond lessonService.list(params), model:[lessonCount: lessonService.count()]
    }

    def show(Long id) {
        respond lessonService.get(id)
    }

    def create() {
        respond new Lesson(params)
    }

    def save(Lesson lesson) {
        if (lesson == null) {
            notFound()
            return
        }

        try {
            lessonService.save(lesson)
        } catch (ValidationException e) {
            respond lesson.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'lesson.label', default: 'Lesson'), lesson.id])
                redirect lesson
            }
            '*' { respond lesson, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond lessonService.get(id)
    }

    def update(Lesson lesson) {
        if (lesson == null) {
            notFound()
            return
        }

        try {
            lessonService.save(lesson)
        } catch (ValidationException e) {
            respond lesson.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'lesson.label', default: 'Lesson'), lesson.id])
                redirect lesson
            }
            '*'{ respond lesson, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        lessonService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'lesson.label', default: 'Lesson'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'lesson.label', default: 'Lesson'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
