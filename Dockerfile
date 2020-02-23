# Base Image
FROM hseeberger/scala-sbt:8u212_1.2.8_2.12.8 AS builder

# Maintainer
LABEL maintainer "royki"

# Update and Install dependency & library for graph dependency
# RUN apt-get update && apt-get install systemd -y
# RUN apt-get install graphviz -y
# ENV JAVA_HOME /usr/local/openjdk-8/

# Project Dir and Environment
ENV PROJECT_DIR /rock-paper-scissor

# Create Project Dir
RUN mkdir -p ${PROJECT_DIR}

# Create folder to share with host
RUN mkdir sharedDoc

# Set Project Path as Work directory
WORKDIR ${PROJECT_DIR}

# Copy Project files
COPY . ${PROJECT_DIR}

# Update Project dependencies & Format codes
RUN sbt update && \
    sbt scalafmt && \
    sbt test:scalafmt
    # sbt scalafix

FROM builder as package
COPY --from=builder ${PROJECT_DIR} .
# Execute tests
RUN sbt test

# Generate documentations in sharedDoc directory
# RUN scaladoc src/main/scala/game/* -d /sharedDoc

# Container run time execution
# CMD [ "sbt", "run" ]