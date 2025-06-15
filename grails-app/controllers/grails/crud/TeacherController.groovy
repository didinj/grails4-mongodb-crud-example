package grails.crud

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class TeacherController {

    TeacherService teacherService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond teacherService.list(params), model:[teacherCount: teacherService.count()]
    }

    def show(Long id) {
        respond teacherService.get(id)
    }

    def create() {
        respond new Teacher(params)
    }

    def save(Teacher teacher) {
        if (teacher == null) {
            notFound()
            return
        }

        try {
            teacherService.save(teacher)
        } catch (ValidationException e) {
            respond teacher.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'teacher.label', default: 'Teacher'), teacher.id])
                redirect teacher
            }
            '*' { respond teacher, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond teacherService.get(id)
    }

    def update(Teacher teacher) {
        if (teacher == null) {
            notFound()
            return
        }

        try {
            teacherService.save(teacher)
        } catch (ValidationException e) {
            respond teacher.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'teacher.label', default: 'Teacher'), teacher.id])
                redirect teacher
            }
            '*'{ respond teacher, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        teacherService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'teacher.label', default: 'Teacher'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'teacher.label', default: 'Teacher'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
