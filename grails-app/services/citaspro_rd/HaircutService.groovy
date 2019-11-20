package citaspro_rd

import grails.gorm.services.Service

@Service(Haircut)
interface HaircutService {

    Haircut get(Serializable id)

    List<Haircut> list(Map args)

    Long count()

    void delete(Serializable id)

    Haircut save(Haircut haircut)

}