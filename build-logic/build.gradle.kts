plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    implementation(libs.detekt.plugin)
    implementation(libs.ktlint.plugin)
    compileOnly(libs.compose.compiler.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidHilt") {
            id = "tnt.android.hilt"
            implementationClass = "co.kr.tnt.HiltAndroidPlugin"
        }
        register("kotlinHilt") {
            id = "tnt.kotlin.hilt"
            implementationClass = "co.kr.tnt.HiltKotlinPlugin"
        }
    }
}
