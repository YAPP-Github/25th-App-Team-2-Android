package co.kr.tnt

import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jlleitschuh.gradle.ktlint.KtlintExtension

internal fun Project.configureKtLint() {
    extensions.configure<KtlintExtension> {
        android.set(true)
        verbose.set(true)
        outputToConsole.set(true)
        additionalEditorconfig.set(
            mapOf(
                "ktlint_standard_no-wildcard-imports" to "disabled",
                "ktlint_standard_filename" to "disabled",
                "ktlint_standard_function-naming" to "disabled",
                "ktlint_standard_function-signature" to "disabled",
                "ktlint_standard_class-naming" to "disabled",
                "ktlint_standard_annotation" to "disabled",
                "ktlint_standard_blank-line-before-declaration" to "disabled",
                "ktlint_standard_string-template-indent" to "disabled",
                "ktlint_standard_multiline-expression-wrapping" to "disabled",
                "max_line_length" to "120"
            )
        )
        reporters {
            reporter(org.jlleitschuh.gradle.ktlint.reporter.ReporterType.PLAIN)
        }
    }
}

internal fun Project.configureDetekt() {
    with(pluginManager) {
        apply("io.gitlab.arturbosch.detekt")
    }

    val libs = extensions.libs
    dependencies {
        "detektPlugins"(libs.findLibrary("detekt.formatting").get())
    }
}
