package com.ara.netty.eco

import com.ara.netty.eco.application.Application

private const val PORT = 8080

fun main() {
    val application = Application()
    application.listen(PORT).run()
}