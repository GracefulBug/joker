FROM frolvlad/alpine-oraclejdk8:slim



ADD target/scav2-backend-0.0.1.jar app.jar
RUN sh -c 'touch /app.jar' \
    && echo "Asia/Shanghai" > /etc/timezone
ENV JAVA_OPTS=""

ENTRYPOINT exec java $JAVA_OPTS -Dfile.encoding=utf-8 -Djava.security.egd=file:/dev/./urandom -jar /app.jar
