package grails.crud

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class TeacherSpec extends Specification implements DomainUnitTest<Teacher> {

     void "test domain constraints"() {
        when:
        Teacher domain = new Teacher()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
