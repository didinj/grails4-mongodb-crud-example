package grails.crud

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TeacherServiceSpec extends Specification {

    TeacherService teacherService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Teacher(...).save(flush: true, failOnError: true)
        //new Teacher(...).save(flush: true, failOnError: true)
        //Teacher teacher = new Teacher(...).save(flush: true, failOnError: true)
        //new Teacher(...).save(flush: true, failOnError: true)
        //new Teacher(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //teacher.id
    }

    void "test get"() {
        setupData()

        expect:
        teacherService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Teacher> teacherList = teacherService.list(max: 2, offset: 2)

        then:
        teacherList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        teacherService.count() == 5
    }

    void "test delete"() {
        Long teacherId = setupData()

        expect:
        teacherService.count() == 5

        when:
        teacherService.delete(teacherId)
        sessionFactory.currentSession.flush()

        then:
        teacherService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Teacher teacher = new Teacher()
        teacherService.save(teacher)

        then:
        teacher.id != null
    }
}
