package play.with.grails.domain

import com.hmtmcse.pgd.InitDataService

class BootStrap {

    InitDataService initDataService

    def init = { servletContext ->
        initDataService.init()
    }
    def destroy = {
    }
}
