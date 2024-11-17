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

## Notes
To avoid repeating typing, we can store some configuration in `jeka.properties`file, as:
```properties
@native.includeAllResources=true
@native.staticLink=MUSL
@docker.nativeBaseImage=gcr.io/distroless/static-debian12:nonroot
```