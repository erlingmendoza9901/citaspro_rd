package citaspro_rd

import grails.gorm.services.Service

@Service(Barber)
interface BarberService {

    Barber get(Serializable id)

    List<Barber> list(Map args)

    Long count()

    void delete(Serializable id)

    Barber save(Barber barber)

}