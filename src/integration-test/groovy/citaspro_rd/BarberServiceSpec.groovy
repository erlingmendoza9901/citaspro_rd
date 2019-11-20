package citaspro_rd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class BarberServiceSpec extends Specification {

    BarberService barberService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Barber(...).save(flush: true, failOnError: true)
        //new Barber(...).save(flush: true, failOnError: true)
        //Barber barber = new Barber(...).save(flush: true, failOnError: true)
        //new Barber(...).save(flush: true, failOnError: true)
        //new Barber(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //barber.id
    }

    void "test get"() {
        setupData()

        expect:
        barberService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Barber> barberList = barberService.list(max: 2, offset: 2)

        then:
        barberList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        barberService.count() == 5
    }

    void "test delete"() {
        Long barberId = setupData()

        expect:
        barberService.count() == 5

        when:
        barberService.delete(barberId)
        sessionFactory.currentSession.flush()

        then:
        barberService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Barber barber = new Barber()
        barberService.save(barber)

        then:
        barber.id != null
    }
}
