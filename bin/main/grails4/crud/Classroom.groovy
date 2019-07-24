package grails4.crud

class Classroom {

    String classroomName
    static hasMany = [students: Student]

    static constraints = {
    }

    static mapping = {
        classroomName index: true
    }

    String toString() {
        classroomName
    }
}
