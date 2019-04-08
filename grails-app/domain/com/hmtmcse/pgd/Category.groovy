package com.hmtmcse.pgd

class Category {

    Integer id
    String name


    Set<Product> products = []
    static hasMany = [products: Product]


    static constraints = {
    }
}
