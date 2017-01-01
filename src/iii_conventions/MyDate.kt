package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (this.year < other.year) {
            return -1;
        } else if (this.year > other.year) {
            return 1;
        } else if (this.month < other.month) {
            return -1;
        } else if (this.month > other.month) {
            return 1;
        } else if (this.dayOfMonth < other.dayOfMonth) {
            return -1;
        } else if (this.dayOfMonth > other.dayOfMonth) {
            return 1;
        } else {
            return 0;
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    operator fun contains(d: MyDate): Boolean {
        return d >= start && d <= endInclusive
    }

    operator fun plus(i: TimeInterval) {

    }

    override fun iterator(): Iterator<MyDate> = object : Iterator<MyDate> {

        private var date = start

        override fun hasNext(): Boolean {
            return contains(date)
        }

        override fun next(): MyDate {
            var temp = date;
            date = date.nextDay()
            return temp
        }
    }
}
