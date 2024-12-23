# JeKa Demo - Build with Zero-Conf

A command-line application that generates and displays an ASCII-art representation of the input string.

This demo shows how this application can be built with Jeka, even though it contains no build configuration.

--------

Compile, tests, create Jar and run the application with specified arguments:
```shell
jeka -p Hello JeKa
```

Run only tests:
```shell
jeka project: test
```

Create Docker Image (need Docker cli):
```shell
jeka docker: build
````

Then run the image:
```shell
docker run --rm demo-zero-conf:latest "Hello Docker"
````

Compile to native executable:
```shell
jeka native: compile includeAllResources=true
```

Once compiled to native, you can execute it (this time, the native executable will run instead of the Java application):
```shell
jeka -p "Hello Native"
```

Create Docker image:
```shell
jeka docker: buildNative native: includeAllResources=true
```

Run the native image:
```shell
docker run --rm native-demo-zero-conf:latest Hello JeKa
```

Execute directly the application from its GIT repo:
```shell
jeka -r https://github.com/jeka-dev/demo-zero-conf.git -p "Hello remote Git" 
```

## Notes
To avoid repetitive typing, you can store configuration in the`jeka.properties` file, like this:
```properties
@native.includeAllResources=true
```
