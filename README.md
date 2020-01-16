# Places to visit

![lenguage java8](https://img.shields.io/badge/language-java8-orange.svg) ![build Gradle](https://img.shields.io/badge/build-Gradle-blue.svg) 
![framework Spring boot](https://img.shields.io/badge/framework-Springboot-yellow.svg)
![coverage 67](https://img.shields.io/badge/coverage-67-green.svg)

## Execution instructions
   
In the root of the project run:

```
./gradlew bootJar
./gradlew jibDockerBuild
docker-compose up
```

## Run test (only with local MongoDB config)

`gradle test`

[coverage](https://drive.google.com/file/d/1_zkH6HGeldIa4EzVj2WdatSab5loHopI/view?usp=sharing)

## Test name

The following convention was used for test names:
```
{method name}_{condition}_{expected Result}
```

For example:
```java
public void validate_placeWithoutImage_isInvalid() {}
```
## Some possible improvements
- When you want to delete a place, add a pop up to confirm the decision.
- Add logs for error tracking.
- Manage paging and list counter from backend.
- Create a db initialization script.
- In case the project grows, the frontend could be separated from the backend.
- Add codecov (or similar) for coverage report.
- Increase coverage percentage.
- Improve form validations: show a more friendly error to the user.

## TODO
- The form should keep the input data from the user when validation fails.
- Persist drag and drop actions in db.
- Configure a specific host and port for the embedded database.