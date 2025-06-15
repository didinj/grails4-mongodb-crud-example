package grails.crud

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class StudentSpec extends Specification implements DomainUnitTest<Student> {

     void "test domain constraints"() {
        when:
        Student domain = new Student()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
