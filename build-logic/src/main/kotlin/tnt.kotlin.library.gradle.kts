import co.kr.tnt.configureKotlin
import co.kr.tnt.configureTest

plugins {
    kotlin("jvm")
    id("tnt.verify.lint")
}

configureKotlin()
configureTest()
