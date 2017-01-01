package ii_collections

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    // Return customers who have more undelivered orders than delivered
//    val (moreDel, moreUndel) = customers.partition { it.orders.count { it.isDelivered } >= it.orders.count { !it.isDelivered }}

//    fun(customer : Customer): Boolean  = {
//        val d = customer.orders.count { it.isDelivered }
//        val count = customer.orders.size
//
//        return count - d > d
//    }
//
//    val (mU, mD) = customers.partition {
//
//    }

    val (moreUndel, moreDel) = customers.partition {

        val delivered = it.orders.count { it.isDelivered }

        val total = it.orders.count();

        total - delivered > delivered;
    }

    return moreUndel.toSet()
}
