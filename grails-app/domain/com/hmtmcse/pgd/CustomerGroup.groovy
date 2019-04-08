package com.hmtmcse.pgd

class CustomerGroup {

    Integer id
    String name

    Set<Customer> customers = []

    static hasMany = [customers: Customer]

    static constraints = {
    }
}
