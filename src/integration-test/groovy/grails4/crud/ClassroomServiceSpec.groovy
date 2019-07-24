package grails4.crud

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ClassroomServiceSpec extends Specification {

    ClassroomService classroomService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Classroom(...).save(flush: true, failOnError: true)
        //new Classroom(...).save(flush: true, failOnError: true)
        //Classroom classroom = new Classroom(...).save(flush: true, failOnError: true)
        //new Classroom(...).save(flush: true, failOnError: true)
        //new Classroom(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //classroom.id
    }

    void "test get"() {
        setupData()

        expect:
        classroomService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Classroom> classroomList = classroomService.list(max: 2, offset: 2)

        then:
        classroomList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        classroomService.count() == 5
    }

    void "test delete"() {
        Long classroomId = setupData()

        expect:
        classroomService.count() == 5

        when:
        classroomService.delete(classroomId)
        sessionFactory.currentSession.flush()

        then:
        classroomService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Classroom classroom = new Classroom()
        classroomService.save(classroom)

        then:
        classroom.id != null
    }
}
