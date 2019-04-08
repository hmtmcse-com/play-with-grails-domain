package com.hmtmcse.pgd

class Customer {

    Integer id
    String name
    String email
    String password
    CustomerGroup baseCustomerGroup
    Set<CustomerGroup> customerGroups

    static belongsTo = CustomerGroup
    static hasMany = [customerGroups: CustomerGroup]
    static mappedBy = [ baseCustomerGroup: "none"]

    static constraints = {
        baseCustomerGroup(nullable: true)
    }
}
