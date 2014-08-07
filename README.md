<h1>hive-simpledate</h1>

SimpeDate UDF für Apache Hive

<h2>Maven</h2>
1. Maven vorbereiten<br>
mvn clean

2. Unittest ausführen<br>
mvn test

3. Jar Builden<br>
mvn install --> hive-simpledate-0.12.0.jar

<h2>Hive</h2>
1. Hive Tabelle erstellen die ein Feld mit einem Datum als String zurückliefert.<br>
Z.b.
datum                   |debug_level |debug_message
Tue Jul 29 10:00:47 2014|info        |Init: Seeding PRNG with 136 bytes of entropy
Tue Jul 29 10:00:47 2014|info        |Init: Generating temporary RSA private keys (512/1024 bits)
Tue Jul 29 10:00:47 2014|info        |Init: Generating temporary DH parameters (512/1024 bits)

2. Hive starten und das Jar mit der Funktion laden<br>
add jar {path}/hive-simpledate-0.12.0-SNAPSHOT.jar;

3. Die Funktion im Hive bekannt machen<br>
create temporary function simpledate as 'ch.circle6.hive.udf.SimpleDateUDF';

4. Die Funktion simpledate verwenden<br>
  -select simpledate(datum, 'EEE MMM dd HH:mm:ss yyyy'), debug_level, debug_message from migzs374_errorlog limit 10;<br>
  -select simpledate(datum, 'EEE MMM dd HH:mm:ss yyyy', 'HH:mm:ss yyyy-MM-dd'), debug_level, debug_message from migzs374_errorlog limit 10;<br>

