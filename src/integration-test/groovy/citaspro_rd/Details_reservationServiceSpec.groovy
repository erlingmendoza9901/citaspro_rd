package citaspro_rd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class Details_reservationServiceSpec extends Specification {

    Details_reservationService details_reservationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Details_reservation(...).save(flush: true, failOnError: true)
        //new Details_reservation(...).save(flush: true, failOnError: true)
        //Details_reservation details_reservation = new Details_reservation(...).save(flush: true, failOnError: true)
        //new Details_reservation(...).save(flush: true, failOnError: true)
        //new Details_reservation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //details_reservation.id
    }

    void "test get"() {
        setupData()

        expect:
        details_reservationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Details_reservation> details_reservationList = details_reservationService.list(max: 2, offset: 2)

        then:
        details_reservationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        details_reservationService.count() == 5
    }

    void "test delete"() {
        Long details_reservationId = setupData()

        expect:
        details_reservationService.count() == 5

        when:
        details_reservationService.delete(details_reservationId)
        sessionFactory.currentSession.flush()

        then:
        details_reservationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Details_reservation details_reservation = new Details_reservation()
        details_reservationService.save(details_reservation)

        then:
        details_reservation.id != null
    }
}
