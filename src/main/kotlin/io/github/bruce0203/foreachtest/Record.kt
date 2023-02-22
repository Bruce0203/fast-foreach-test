package io.github.bruce0203.foreachtest

import org.eclipse.jgit.api.Git
import java.io.File

fun record(result: Double) {
    Git.open(File(".git")).apply {
        if (!branchList().call().any { it.name == "result" }) {
            branchCreate().apply { setName("result") }.call()
        }
        checkout().apply { setName("result") }.call()
        File("result.txt").apply {
            if(!exists()) createNewFile()
            writeText(readText().plus("\n$result"))
        }
        add().apply {  }.call()
        commit().apply { message = "YeY" }.call()
        push().apply {  }.call()
        checkout().apply { setName("main") }.call()
    }
}