package com.example

import com.tschuchort.compiletesting.KotlinCompilation
import com.tschuchort.compiletesting.KotlinCompilation.ExitCode
import com.tschuchort.compiletesting.SourceFile
import kotlin.test.Test
import kotlin.test.assertEquals
import org.intellij.lang.annotations.Language
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi

@OptIn(ExperimentalCompilerApi::class)
class ExampleTest {

    @Test
    fun example() {
        @Language("kotlin")
        val source = """
        package com.example.source

        data class Foo(val bar: String)
        """.trimIndent()

        val sourceFile = SourceFile.kotlin("Foo.kt", source)

        val result = KotlinCompilation().apply {
            compilerPluginRegistrars = listOf(ExampleCompilerPluginRegistrar())
            inheritClassPath = true
            messageOutputStream = System.out
            sources = listOf(sourceFile)
        }.compile()

        assertEquals(ExitCode.OK, result.exitCode)
    }
}