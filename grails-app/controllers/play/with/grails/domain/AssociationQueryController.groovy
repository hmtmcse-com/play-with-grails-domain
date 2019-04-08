package play.with.grails.domain

import com.hmtmcse.pgd.Category
import com.hmtmcse.pgd.DiscountAssociation

class AssociationQueryController {

    def index() {

        def dell = Category.findByName("Dell")
        def data = DiscountAssociation.createCriteria().list {
            categories {
                eq("id", dell.id)
            }
        }
        println(data)

        render("Result")
    }
}
