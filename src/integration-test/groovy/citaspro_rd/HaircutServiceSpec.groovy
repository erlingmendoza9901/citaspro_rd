package citaspro_rd

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class HaircutServiceSpec extends Specification {

    HaircutService haircutService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Haircut(...).save(flush: true, failOnError: true)
        //new Haircut(...).save(flush: true, failOnError: true)
        //Haircut haircut = new Haircut(...).save(flush: true, failOnError: true)
        //new Haircut(...).save(flush: true, failOnError: true)
        //new Haircut(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //haircut.id
    }

    void "test get"() {
        setupData()

        expect:
        haircutService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Haircut> haircutList = haircutService.list(max: 2, offset: 2)

        then:
        haircutList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        haircutService.count() == 5
    }

    void "test delete"() {
        Long haircutId = setupData()

        expect:
        haircutService.count() == 5

        when:
        haircutService.delete(haircutId)
        sessionFactory.currentSession.flush()

        then:
        haircutService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Haircut haircut = new Haircut()
        haircutService.save(haircut)

        then:
        haircut.id != null
    }
}
