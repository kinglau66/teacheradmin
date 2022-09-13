# teacheradmin
## Link to hosted api
`https://teacheradmin.herokuapp.com/`

postmen collection (and openapi docs) is located at /collection/*
## To run the application
First, build the application with following
```
mvnw -Pdev verify jib:dockerBuild -DskipTests
```

Then run:

```
docker-compose -f src/main/docker/app-dev.yml up 
```


