package play.with.grails.domain

import com.hmtmcse.pgd.Category
import com.hmtmcse.pgd.Customer
import com.hmtmcse.pgd.DiscountAssociation

class AssociationQueryController {

    def index() {

        def dell = Category.findByName("Apple")
        def certainCustomer = Customer.findByName("Abul")
        def data = DiscountAssociation.createCriteria().list {
            categories {
                eq("id", dell.id)
            }
            customers{
                eq("id", certainCustomer.id)
            }
        }
        println(data)

        render("Result")
    }
}
