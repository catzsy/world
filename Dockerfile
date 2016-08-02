FROM anapsix/alpine-java:jdk8
MAINTAINER Catz Sy <sy.catz@gmail.com> 
EXPOSE 5556
ADD /build/libs/world-server.jar /world-server.jar
ENTRYPOINT ["java", "-jar", "world-server.jar"]