# Create sbt plugin
How build sbt plugin:<br/>
1- Run sbt<br/>
2- Run compile<br/>
3- Run publishLocal<br/>

# How to use sbt plugin. 
<br/>1- Add plugin in plugins.sbt<br/>
addSbtPlugin("com.abtechsoft" % "sbt-plugin-practice" % "1.0")<br/>
2- Enable sbt plugin<br/>
enablePlugins(LocPlugin)
3- Run sbt task
sbt loc

