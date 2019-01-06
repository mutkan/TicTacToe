object Versions {
    val support_lib = "28.0.0"
    val kotlin_version = "1.3.10"
    val support_constraint = "1.1.3"
    val arch_core_testing = "1.1.1"
    val arch_lifecycle_ext = "1.1.1"
    val support_test = "1.0.2"
    val support_test_espresso = "3.0.2"
    val junit = "4.12"
    val compile_sdk = 28
    val min_sdk = 16
    val target_sdk = 28
    val version_code = 1
    val version_name = "1.0"
    val android_gradle_plugin="3.2.1"

}

object Deps {
    val support_annotations = "com.android.support:support-annotations:${Versions.support_lib}"
    val support_appcompat_v7 = "com.android.support:appcompat-v7:${Versions.support_lib}"
    val support_design = "com.android.support:design:${Versions.support_lib}"
    val support_gridlayout_v7 = "com.android.support:gridlayout-v7:${Versions.support_lib}"
    val support_constraint = "com.android.support.constraint:constraint-layout:${Versions.support_constraint}"
    val support_test_runner = "com.android.support.test:runner:${Versions.support_test}"
    val support_test_rules = "com.android.support.test:rules:${Versions.support_test}"
    val support_test_espresso_core = "com.android.support.test.espresso:espresso-core:${Versions.support_test_espresso}"

    val arch_core_testing = "android.arch.core:core-testing:${Versions.arch_core_testing}"
    val kotlin_stblib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin_version}"
    val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin_version}"
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"

    val junit = "junit:junit:${Versions.junit}"
    val arch_lifecycle_ext = "android.arch.lifecycle:extensions:${Versions.arch_lifecycle_ext}"
}
