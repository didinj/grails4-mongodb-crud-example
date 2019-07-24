package grails4.crud

class Lesson {

    String lessonName
    Integer lessonHour
    Teacher teacher
    static hasMany = [students: Student]

    static constraints = {
        teacher blank: true, nullable: true
    }

    static mapping = {
        lessonName index: true
    }

    String toString() {
        lessonName
    }
}
