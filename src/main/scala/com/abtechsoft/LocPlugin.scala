package com.abtechsoft

import sbt.Keys.{baseDirectory, streams}
import sbt.{AutoPlugin, Def, IO, Path, PatternFilter, TaskKey}

  object LocPlugin extends AutoPlugin {

  object autoImport {
    lazy val loc: TaskKey[Unit] = TaskKey("loc")
  }

  import autoImport._

  override def projectSettings: Seq[Def.Setting[_]] = Seq(
    loc := {
      //Process("ls -ltr").lines.foreach(println)
      val log = streams.value.log
      val paths = Path.allSubpaths(baseDirectory.value)
      val scalaFileFiler = new PatternFilter(""".*\.scala$""".r.pattern)
      val files = paths.flatMap(path => IO.listFiles(path._1, scalaFileFiler)).toSeq
      val rawLines = files.flatMap(IO.readLines(_))
      val nrTotal = rawLines.length
      val nrBlank = rawLines.count(_.trim.length == 0)
      val commentRegex ="""^$*//.*$""".r
      val nrComments = rawLines.count(line => commentRegex.findFirstIn(line).isDefined)
      log.info(s"Files: ${files.length}")
      log.info(s"Total Lines: $nrTotal")
      log.info(s"Blank: $nrBlank")
      log.info(s"Comments: $nrComments")
      log.info(s"Actual Code: ${nrTotal - nrBlank - nrComments}")
    }
  )

}
