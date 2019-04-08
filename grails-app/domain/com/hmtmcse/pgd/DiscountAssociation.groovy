package com.hmtmcse.pgd

class DiscountAssociation {

    Integer id
    String name
    String code
    Boolean isActive = true

    Set<Customer> customers = []
    Set<CustomerGroup> customerGroups = []
    Set<Product> products = []
    Set<Category> categories = []


    static hasMany = [customers: Customer, customerGroups: CustomerGroup, products: Product, categories: Category]

    static constraints = {
        customers(nullable: true)
        customerGroups(nullable: true)
        products(nullable: true)
        categories(nullable: true)
    }
}
