package com.example

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.compiler.plugin.AbstractCliOption
import org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor

@AutoService(CommandLineProcessor::class)
public class ExampleCommandLineProcessor : CommandLineProcessor {
    override val pluginId: String
        get() = "exampleCompilerPlugin"

    override val pluginOptions: Collection<AbstractCliOption>
        get() = emptyList()
}