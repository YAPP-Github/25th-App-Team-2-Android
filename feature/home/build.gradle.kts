import co.kr.tnt.setNamespace

plugins {
    id("tnt.android.feature")
}

android {
    setNamespace("feature.home")
}

dependencies {
    implementation(libs.kotlinx.immutable)
}
