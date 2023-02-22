package io.github.bruce0203.foreachtest

import org.eclipse.jgit.api.Git
import java.io.File

fun record(result: Double) {
    val resultBranch = "result"
    Git.open(File(".git")).apply {
        if (branchList().call().none { it.name == "refs/heads/$resultBranch" }) {
            branchCreate().apply { setName(resultBranch) }.call()
        }
        checkout().apply { setName(resultBranch) }.call()
        File("result.txt").apply {
            if(!exists()) createNewFile()
            writeText(readText().plus("\n$result"))
        }
        add().apply { addFilepattern("*") }.call()
        commit().apply { message = "YeY" }.call()
        push().apply {  }.call()
        checkout().apply { setName("main") }.call()
    }
}