# JeKa Demo - Build with Zero-Conf

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
docker run --rm demo-zero-conf:latest Hello Docker
````

Compile to native executable:
```shell
jeka native: compile includeAllResources=true
```

Once compile to native, you can execute it with previous command:
```shell
jeka -p Hello Native
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