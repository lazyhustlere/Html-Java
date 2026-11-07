FROM tomcat:9.0-jdk17-temurin
# Clear default Tomcat webapps
RUN rm -rf /usr/local/tomcat/webapps/*
# Copy WAR file as the ROOT application
COPY JewelleryWebsite.java /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]