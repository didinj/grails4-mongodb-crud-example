package grails.crud

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ClassroomSpec extends Specification implements DomainUnitTest<Classroom> {

     void "test domain constraints"() {
        when:
        Classroom domain = new Classroom()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
