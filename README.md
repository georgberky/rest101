# REST101
A basic project to get you started with Jersey

## How to create the base archetype:
```bash
mvn archetype:generate -DarchetypeArtifactId=jersey-quickstart-grizzly2 -DarchetypeGroupId=org.glassfish.jersey.archetypes -DgroupId=de.gb -DartifactId=rest101 -Dpackage=de.gb.rest -DarchetypeVersion=2.25.1
```

## How to run
mvn clean package exec:java

## Where to find your resource?
```bash
curl -v -H "Accept:text/plain" http://localhost:8080/myapp/gotit
```

Or make your browser go to: <http://localhost:8080/myapp/gotit>

## How to GET JSON
```bash
curl -v --header "Accept:application/json" http://localhost:8080/myapp/gotit
```

## How to PUT JSON
```bash
curl -v -X PUT -H "Content-Type:application/json" -d '{"message":"Hello World"}' http://localhost:8080/myapp/gotit
```
