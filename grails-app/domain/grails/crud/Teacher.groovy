package grails.crud

class Teacher {

    String teacherName
    static hasOne = [lesson: Lesson]

    static constraints = {
        lesson blank: true, nullable: true
    }

    static mapping = {
        teacherName index: true
    }

    String toString() {
        teacherName
    }
}