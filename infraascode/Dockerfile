FROM gradle:latest

# Create app directory
WORKDIR /usr/src/app

COPY ./build/libs/springsrvc-0.0.1-SNAPSHOT.jar ./spring_srvc.jar
COPY ./startup.sh  ./startup.sh


EXPOSE 8080

CMD [ "./startup.sh" ]