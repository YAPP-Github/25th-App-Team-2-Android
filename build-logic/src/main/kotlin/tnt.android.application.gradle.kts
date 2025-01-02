import co.kr.tnt.configureHiltAndroid
import co.kr.tnt.configureKotlinAndroid
import co.kr.tnt.configureTest

plugins {
    id("com.android.application")
}

configureKotlinAndroid()
configureHiltAndroid()
configureTest()
