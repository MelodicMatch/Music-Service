# Use an official Tomcat image as a parent image
FROM tomcat:9.0.68-jdk17-openjdk-slim

# Remove the default webapps to save space
RUN rm -rf /usr/local/tomcat/webapps/*

# Download and install OpenJDK 21 (example with an early-access build)
RUN apt-get update && apt-get install -y wget && \
    wget https://download.java.net/java/early_access/jdk21/20/GPL/openjdk-21-ea+20_linux-x64_bin.tar.gz && \
    tar -xzf openjdk-21-ea+20_linux-x64_bin.tar.gz && \
    mv jdk-21 /usr/local/ && \
    apt-get remove -y wget && apt-get autoremove -y && apt-get clean

# Set JAVA_HOME environment variable
ENV JAVA_HOME /usr/local/jdk-21
ENV PATH $JAVA_HOME/bin:$PATH

# Set the working directory in the container
WORKDIR /usr/local/tomcat

# Copy the project WAR file to the webapps directory of Tomcat
COPY target/music_service.war /usr/local/tomcat/webapps/ROOT.war

# Expose the port the application runs on
EXPOSE 8084

# Start Tomcat server
CMD ["catalina.sh", "run"]
