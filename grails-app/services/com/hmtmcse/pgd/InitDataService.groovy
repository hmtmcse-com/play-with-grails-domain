package com.hmtmcse.pgd


class InitDataService {

    def category() {
        Category.saveAll(
                new Category(name: "Laptop"),
                new Category(name: "Display"),
                new Category(name: "Keyboard"),
                new Category(name: "Mouse"),
                new Category(name: "Apple"),
                new Category(name: "Dell"),
                new Category(name: "Asus"),
                new Category(name: "HP"),
                new Category(name: "Lenovo"),
        )
    }


    def product(){
        Category laptopCommonCategory = Category.findByName("Laptop")
        Category appleBaseCategory = Category.findByName("Apple")
        Category dell = Category.findByName("Dell")
        [
                [name: "MackBook", price: 10.0, categories:[], baseCategory: appleBaseCategory],
                [name: "MackBook Air 13-inch", price: 15.0, categories:[laptopCommonCategory], baseCategory: appleBaseCategory],
                [name: "MackBook Pro 13-inch", price: 20.0, categories:[laptopCommonCategory], baseCategory: appleBaseCategory],

                [name: "Inspiron", price: 5.0, categories:[laptopCommonCategory], baseCategory: dell],
                [name: "XPS", price: 50.0, categories:[laptopCommonCategory], baseCategory: dell],
                [name: "G3", price: 55.0, categories:[laptopCommonCategory], baseCategory: dell],
                [name: "G5", price: 56.0, categories:[laptopCommonCategory], baseCategory: dell],
                [name: "G7", price: 57.0, categories:[laptopCommonCategory], baseCategory: dell],
                [name: "Alienware", price: 30.0, categories:[laptopCommonCategory], baseCategory: dell],
        ].each { product ->
            Product productDomain = new Product(product)
            if (product.baseCategory){
                productDomain.baseCategory = product.baseCategory
            }
            product.categories.each {
                productDomain.addToCategories(it)
            }
            productDomain.save()
            if (productDomain.hasErrors()){
                productDomain.errors.each {
                    println(it)
                }
            }
        }
    }


    def customerGroup(){
        CustomerGroup.saveAll(
                new CustomerGroup(name: "Regular"),
                new CustomerGroup(name: "VIP"),
                new CustomerGroup(name: "Membership"),
                new CustomerGroup(name: "Customer"),
        )
    }


    def customer(){
        CustomerGroup customerGroupBase = CustomerGroup.findByName("Customer")
        CustomerGroup regularCustomer = CustomerGroup.findByName("Regular")
        CustomerGroup vipCustomer = CustomerGroup.findByName("VIP")
        [
                [name: "Abul", email: "abul@pgd.local", password: "123456", gruops:[], baseGroup: customerGroupBase],
                [name: "Kabul", email: "abul@pgd.local", password: "123456", gruops:[regularCustomer], baseGroup: null],
                [name: "Maya", email: "abul@pgd.local", password: "123456", gruops:[vipCustomer], baseGroup: null],
                [name: "Nishi", email: "abul@pgd.local", password: "123456", gruops:[regularCustomer], baseGroup: customerGroupBase],
        ].each { customer ->
           Customer customerDomain = new Customer(customer)
            if (customer.baseGroup){
                customerDomain.baseCustomerGroup = customer.baseGroup
            }
            customer.groups.each {
                customerDomain.addToCustomerGroups(it)
            }
            customerDomain.save()
            if (customerDomain.hasErrors()){
                customerDomain.errors.each {
                    println(it)
                }
            }
        }
    }

    def discountAssociation(){
        DiscountAssociation discountAssociation = new DiscountAssociation(name: "Summer Assoc For Abul, Kabul on Dell", code: "DA-DELL")
        discountAssociation.addToCustomers(Customer.findByName("Abul"))
        discountAssociation.addToCustomers(Customer.findByName("Kabul"))
        discountAssociation.addToCategories(Category.findByName("Dell"))
        discountAssociation.save()
        if (discountAssociation.hasErrors()){
            discountAssociation.errors.each {
                println(it)
            }
        }

        discountAssociation = new DiscountAssociation(name: "Summer Assoc For VIP Customer Group & Apple", code: "DA-APPLE")
        discountAssociation.addToCustomerGroups(CustomerGroup.findByName("VIP"))
        discountAssociation.addToProducts(Product.findByName("MackBook"))
        discountAssociation.addToProducts(Product.findByName("MackBook Air 13-inch"))
        discountAssociation.addToProducts(Product.findByName("MackBook Pro 13-inch"))
        discountAssociation.save()
        if (discountAssociation.hasErrors()){
            discountAssociation.errors.each {
                println(it)
            }
        }
    }

    def discount(){
        Discount.saveAll(
                new Discount(name: "For Abul Kabul", amount: 1.10, discountAssociation: DiscountAssociation.findByCode("DA-DELL")),
                new Discount(name: "For VIP Customer", amount: 3.00, discountAssociation: DiscountAssociation.findByCode("DA-APPLE")),
        )
    }

    def init(){
        category()
        product()
        customerGroup()
        customer()
        discountAssociation()
        discount()
    }

}
