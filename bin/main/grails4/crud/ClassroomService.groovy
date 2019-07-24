package grails4.crud

import grails.gorm.services.Service

@Service(Classroom)
interface ClassroomService {

    Classroom get(Serializable id)

    List<Classroom> list(Map args)

    Long count()

    void delete(Serializable id)

    Classroom save(Classroom classroom)

}