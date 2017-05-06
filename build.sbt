name := "sbt-plugin-practice"

version := "1.0"

scalaVersion := "2.10.6"

organization := "com.abtechsoft"

sbtPlugin := true

/*Settings are calculate only once
lazy val mySettings: SettingKey[Long] = SettingKey("mySettings")
mySettings := System.currentTimeMillis()
*/

/*
Task is calculate every time
lazy val myTask: TaskKey[Long] = TaskKey("myTask")
myTask := System.currentTimeMillis()
*/