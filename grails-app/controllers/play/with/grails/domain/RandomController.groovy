package play.with.grails.domain

import com.hmtmcse.pgd.Packager

class RandomController {

    def groupByAndCount() {
        def data = Packager.createCriteria().list {
            projections{
                groupProperty("code")
                count("code")

            }
        }
        println(data)
        render("Worked")
    }

    def groupByAndCountInList() {
        def data = Packager.createCriteria().list {
            projections{
                groupProperty("code")
                count("code")

            }
            inList("id", [1,5,2])
        }
        println(data)
        render("Worked")
    }
}
