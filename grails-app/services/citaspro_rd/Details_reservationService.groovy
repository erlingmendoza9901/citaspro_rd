package citaspro_rd

import grails.gorm.services.Service

@Service(Details_reservation)
interface Details_reservationService {

    Details_reservation get(Serializable id)

    List<Details_reservation> list(Map args)

    Long count()

    void delete(Serializable id)

    Details_reservation save(Details_reservation details_reservation)

}