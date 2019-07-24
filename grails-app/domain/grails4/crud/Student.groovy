package grails4.crud

class Student {

    String studentName
    static hasMany = [lessons: Lesson]
    static belongsTo = [Classroom]

    static constraints = {
    }

    static mapping = {
        studentName index: true
    }

    String toString() {
        studentName
    }
}
