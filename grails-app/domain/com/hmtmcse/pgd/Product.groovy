package com.hmtmcse.pgd

class Product {

    Integer id
    String name
    Double price

    Category baseCategory
    Set<Category> categories

    static belongsTo = Category
    static hasMany = [categories: Category]

    static mappedBy = [ baseCategory: "none"]

    static constraints = {
        baseCategory(nullable: true)
    }
}
