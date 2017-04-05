# REST101
A basic project to get you started with Jersey

## How to create the base archetype:
```bash
mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-grizzly2 -DarchetypeGroupId=org.glassfish.jersey.archetypes -DgroupId=de.gb -DartifactId=rest101 -Dpackage=de.gb.rest -DarchetypeVersion=2.25.1
```

## How to run
mvn clean package exec:java

## Where to find your resource?
http://localhost:8080/myapp/myresource
