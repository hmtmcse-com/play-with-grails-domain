package com.hmtmcse.pgd

class Customer {

    Integer id
    String name
    String email
    String password
    CustomerGroup baseCustomerGroup
    Set<CustomerGroup> customerGroups

    static hasMany = [customerGroups: CustomerGroup]

    static constraints = {
        baseCustomerGroup(nullable: true)
    }
}
