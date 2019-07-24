package grails4.crud

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ClassroomController {

    ClassroomService classroomService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond classroomService.list(params), model:[classroomCount: classroomService.count()]
    }

    def show(Long id) {
        respond classroomService.get(id)
    }

    def create() {
        respond new Classroom(params)
    }

    def save(Classroom classroom) {
        if (classroom == null) {
            notFound()
            return
        }

        try {
            classroomService.save(classroom)
        } catch (ValidationException e) {
            respond classroom.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'classroom.label', default: 'Classroom'), classroom.id])
                redirect classroom
            }
            '*' { respond classroom, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond classroomService.get(id)
    }

    def update(Classroom classroom) {
        if (classroom == null) {
            notFound()
            return
        }

        try {
            classroomService.save(classroom)
        } catch (ValidationException e) {
            respond classroom.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'classroom.label', default: 'Classroom'), classroom.id])
                redirect classroom
            }
            '*'{ respond classroom, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        classroomService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'classroom.label', default: 'Classroom'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'classroom.label', default: 'Classroom'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
