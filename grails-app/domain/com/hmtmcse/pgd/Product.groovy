package com.hmtmcse.pgd

class Product {

    Integer id
    String name
    Double price

    Category baseCategory
    Set<Category> categories

    static hasMany = [categories: Category]

    static constraints = {
        baseCategory(nullable: true)
    }
}
