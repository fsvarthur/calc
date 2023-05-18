FROM payara/server-web:6.2023.2-jdk17

COPY target/postgresql.jar /tmp
COPY target/calc.war /tmp
COPY post-boot-commands.asadmin /opt/payara/config/