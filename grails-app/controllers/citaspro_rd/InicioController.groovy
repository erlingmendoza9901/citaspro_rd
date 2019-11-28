package citaspro_rd

import org.springframework.web.servlet.ModelAndView

class InicioControlador {

    static layout = 'principal'


    def index() {

        def lista = Barber.findAll();
        return new ModelAndView("lista_barber",[lista:lista]);

    }
}
