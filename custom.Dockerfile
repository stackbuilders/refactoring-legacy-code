FROM debian:jessie

COPY jdk-6u45-linux-x64.bin /tmp

RUN cd /tmp && \
    ./jdk-6u45-linux-x64.bin && \
    mkdir -p /opt/jdk && \
    mv jdk1.6.0_45 /opt/jdk/1.6.0 && \
    rm jdk-6u45-linux-x64.bin

ENV JAVA_HOME /opt/jdk/1.6.0
ENV PATH $JAVA_HOME/bin:$PATH

RUN apt-get update && \
    apt-get install -y curl && \
    rm -rf /var/lib/apt/lists/*

ENV MAVEN_VERSION 3.2.5

RUN cd /tmp && \
    curl https://www-us.apache.org/dist/maven/maven-3/$MAVEN_VERSION/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz | tar -xz && \
    mkdir -p /opt/mvn && \
    mv apache-maven-$MAVEN_VERSION /opt/mvn/$MAVEN_VERSION

ENV PATH /opt/mvn/$MAVEN_VERSION/bin:$PATH

COPY . /root/javaday

WORKDIR /root/javaday
