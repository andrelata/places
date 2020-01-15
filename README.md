# Places to visit

![lenguage java8](https://img.shields.io/badge/language-java8-orange.svg) ![build Gradle](https://img.shields.io/badge/build-Gradle-blue.svg) 
![framework Spring boot](https://img.shields.io/badge/framework-Springboot-yellow.svg)

## Execution instructions
   
In the root of the project run:

```
./gradlew bootJar
./gradlew jibDockerBuild
docker-compose up
```

## Run test (only with local MongoDB config)

`gradle test`

## Test name

The following convention was used for test names:
```
{method name}_{condition}_{expected Result}
```

For example:
```java
public void validate_placeWithoutImage_isInvalid() {}
```

