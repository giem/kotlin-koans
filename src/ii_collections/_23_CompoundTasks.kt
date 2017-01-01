package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
    return customers.filter { it.orders.flatMap { it.products }.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders
            .filter { it.isDelivered }
            .flatMap { it.products }
            .reduce { product, p ->
                if (product.price > p.price) {
                    return product
                } else {
                    return p
                }
             }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.

    return customers
            .flatMap { it.orders }
            .flatMap { it.products }
            .fold(0, {count, p -> if (p == product) count + 1 else count})
}
