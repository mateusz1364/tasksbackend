FROM tomcat:8.5-jdk17-temurin
ADD target/tasks-management-1.0.0.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]