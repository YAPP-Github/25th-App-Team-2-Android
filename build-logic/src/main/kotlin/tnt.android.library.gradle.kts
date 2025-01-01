import co.kr.tnt.configureCoroutineAndroid
import co.kr.tnt.configureHiltAndroid
import co.kr.tnt.configureKotlinAndroid
import co.kr.tnt.configureTest

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureCoroutineAndroid()
configureHiltAndroid()
configureTest()
