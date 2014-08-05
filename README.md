<h1>hive-simpledate</h1>

SimpeDate UDF für Apache Hive

<h2>Maven</h2>
1. Maven vorbereiten
mvn clean

2. Unittest ausführen
mvn test

3. Jar Builden
mvn install --> hive-simpledate-0.12.0-SNAPSHOT.jar

<h2>Hive</h2>
1. Hive starten und das Jar mit der Funktion laden
add jar {path}/hive-simpledate-0.12.0-SNAPSHOT.jar;

2. Die Funktion im Hive bekannt machen
create temporary function simpledate as 'ch.circle6.hive.udf.SimpleDateUDF';

3. Die Funktion simpledate verwenden<br>
  -select simpledate(datum, 'EEE MMM dd HH:mm:ss yyyy'), debug_level, debug_message from migzs374_errorlog limit 10;<br>
  -select simpledate(datum, 'EEE MMM dd HH:mm:ss yyyy', 'HH:mm:ss yyyy-MM-dd'), debug_level, debug_message from migzs374_errorlog limit 10;<br>

