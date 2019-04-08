package com.hmtmcse.pgd

class DiscountAssociation {

    Integer id
    String name

    Set<Customer> customers = []
    Set<CustomerGroup> customerGroups = []
    Set<Product> products = []
    Set<Category> categories = []



    static constraints = {
        customers(nullable: true)
        customerGroups(nullable: true)
        products(nullable: true)
        categories(nullable: true)
    }
}
