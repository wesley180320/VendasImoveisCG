FROM tomcat:11-jdk21

COPY target/imobiliaria-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/imobiliaria.war

EXPOSE 8080

CMD ["catalina.sh", "run"]