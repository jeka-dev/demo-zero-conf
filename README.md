# JeKa Demo - Build with Zero-Conf

This demo builds, tests and runs a Java application with JeKa, without any build configuration:
no `jeka.properties`, no build code. JeKa finds the sources in `src/main/java` and `src/test/java`,
and the dependencies in [jeka.project.deps](jeka.project.deps).

The application is a command-line tool that prints an ASCII-art version of its arguments.

## Prerequisites

- [JeKa installed](https://jeka-dev.github.io/jeka/installation/). JeKa downloads the JDK it needs.
- Docker, for the Docker images.

## Run it

Compile, create the jar if it is missing, and run the application with arguments (tests are skipped):
```shell
jeka -p Hello JeKa
```

Run the tests:
```shell
jeka project: test
```

Build the jar with `project: pack`: it is a library jar, with no `Main-Class`.
To run it with `-p`, add `-c` so JeKa cleans the output and rebuilds it as a runnable jar:
```shell
jeka -c -p Hello JeKa
```

Create a Docker image (needs Docker):
```shell
jeka docker: build
```

Then run the image:
```shell
docker run --rm demo-zero-conf:latest "Hello Docker"
```

Compile to a native executable (JeKa downloads GraalVM if needed):
```shell
jeka native: compile includeAllResources=true
```

Once compiled, `-p` runs the native executable instead of the jar:
```shell
jeka -p "Hello Native"
```

Create a native Docker image:
```shell
jeka docker: buildNative native: includeAllResources=true
```

Run the native image:
```shell
docker run --rm native-demo-zero-conf:latest Hello JeKa
```

Run the application directly from its Git repository, without cloning it yourself:
```shell
jeka -r https://github.com/jeka-dev/demo-zero-conf.git -p "Hello remote Git"
```

## How it works

- `src/main/java` and `src/test/java`: the standard layout, detected by JeKa.
- [jeka.project.deps](jeka.project.deps): the dependencies, by scope (`[compile]`, `[test]`), with a BOM in `[version]`.

To avoid typing options again, you can store them in a `jeka.properties` file, like this:
```properties
@native.includeAllResources=true
```

## Links

- [Build projects](https://jeka-dev.github.io/jeka/tutorials/build-projects/)
- [project KBean](https://jeka-dev.github.io/jeka/reference/kbeans-project/)
- [docker KBean](https://jeka-dev.github.io/jeka/reference/kbeans-docker/)
- [native KBean](https://jeka-dev.github.io/jeka/reference/kbeans-native/)
