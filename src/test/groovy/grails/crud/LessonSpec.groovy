package grails.crud

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class LessonSpec extends Specification implements DomainUnitTest<Lesson> {

     void "test domain constraints"() {
        when:
        Lesson domain = new Lesson()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
