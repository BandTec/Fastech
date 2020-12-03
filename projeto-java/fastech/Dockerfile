FROM openjdk:8

WORKDIR /linus

RUN cd /linus

COPY /target/fastech-1.0-SNAPSHOT-jar-with-dependencies.jar /linus/

RUN cd /linus/

CMD java -jar /linus/fastech-1.0-SNAPSHOT-jar-with-dependencies.jar
