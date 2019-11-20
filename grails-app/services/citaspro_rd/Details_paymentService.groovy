package citaspro_rd

import grails.gorm.services.Service

@Service(Details_payment)
interface Details_paymentService {

    Details_payment get(Serializable id)

    List<Details_payment> list(Map args)

    Long count()

    void delete(Serializable id)

    Details_payment save(Details_payment details_payment)

}