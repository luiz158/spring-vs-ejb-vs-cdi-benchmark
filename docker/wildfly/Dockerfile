# Use latest jboss/base-jdk:8 image as the base
FROM jboss/base-jdk:8

# Set the WILDFLY_VERSION env variable
ENV WILDFLY_VERSION 10.0.0.Final
ENV WILDFLY_SHA1 c0dd7552c5207b0d116a9c25eb94d10b4f375549
ENV JBOSS_HOME /opt/jboss/wildfly

# Add the WildFly distribution to /opt, and make wildfly the owner of the extracted tar content
# Make sure the distribution is available from a well-known place
RUN cd $HOME \
    && curl -O https://download.jboss.org/wildfly/$WILDFLY_VERSION/wildfly-$WILDFLY_VERSION.tar.gz \
    && sha1sum wildfly-$WILDFLY_VERSION.tar.gz | grep $WILDFLY_SHA1 \
    && tar xf wildfly-$WILDFLY_VERSION.tar.gz \
    && mv $HOME/wildfly-$WILDFLY_VERSION $JBOSS_HOME \
    && rm wildfly-$WILDFLY_VERSION.tar.gz

# Ensure signals are forwarded to the JVM process correctly for graceful shutdown
ENV LAUNCH_JBOSS_IN_BACKGROUND true


# Expose the ports we're interested in
EXPOSE 8080 9990 8009

ADD https://github.com/rmpestano/spring-vs-ejb-vs-cdi-benchmark/archive/master.zip /opt

ADD exec.sh /opt

USER root

RUN chmod a+x -R /opt

WORKDIR /opt

RUN unzip master

WORKDIR /opt/spring-vs-ejb-vs-cdi-benchmark-master

#RUN yum -y install maven && yum clean all

RUN yum -y install wget && wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo

RUN yum -y install apache-maven

#RUN mvn -version 

RUN mvn clean package && cp rest-ws-application/target/rest-ws-application.ear $JBOSS_HOME/standalone/deployments && cp rest-benchmark/target/rest-benchmarks.jar /opt

USER jboss

#ADD rest-ws-application/target/rest-ws-application.ear $JBOSS_HOME/standalone/deployments

# Set the default command to run on boot
# This will boot WildFly in the standalone mode and bind to all interface
#CMD ["/opt/wildfly/bin/standalone.sh", "-c", "standalone.xml", "-b", "0.0.0.0"]

CMD ["/opt/exec.sh"]
