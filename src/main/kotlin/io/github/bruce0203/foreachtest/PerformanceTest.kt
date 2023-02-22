package io.github.bruce0203.foreachtest

import java.util.*
import kotlin.system.measureNanoTime

class PerformanceTest {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val list = generateList()
            repeat (3) { measure(list) }
            val result = measure(list)
            val resultString = result.apply {
                println("forEach=$first, fastForEach=$second")
            }
            val bar = "=".repeat(20)
            println(bar)
            println(resultString)
            val timesResult = result.first.toDouble() / result.second.toDouble()
            println("fast than $timesResult")
            println(bar)
            record(timesResult)
        }

        private fun generateList(): MutableList<String> {
            return (1..10000).map { newRandomString() }.toMutableList()
        }

        private fun measure(list: List<String>): Pair<Long, Long> {
            val times = 100000
            val a = measureNanoTime {
                repeat(times) {
                    list.forEach { }
                }
            }
            val b = measureNanoTime {
                repeat(times) {
                    list.fastForEach { }
                }
            }
            return Pair(a, b)
        }

        private fun newRandomString() = UUID.randomUUID().toString()

        private inline fun <T> List<T>.fastForEach(callback: (T) -> Unit) {
            var n = 0
            while (n < size) callback(this[n++])
        }
    }
}

