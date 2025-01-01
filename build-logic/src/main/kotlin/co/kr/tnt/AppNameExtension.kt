package co.kr.tnt

import org.gradle.api.Project

fun Project.setNamespace(name: String) {
    androidExtension.apply {
        namespace = "co.kr.tnt.$name"
    }
}
