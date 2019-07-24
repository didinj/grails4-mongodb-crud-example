package grails4.crud

import grails.gorm.services.Service

@Service(Teacher)
interface TeacherService {

    Teacher get(Serializable id)

    List<Teacher> list(Map args)

    Long count()

    void delete(Serializable id)

    Teacher save(Teacher teacher)

}