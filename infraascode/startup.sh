#!/bin/bash

echo "The environment is set to ${PROJ_ENV}"

if [ "$PROJ_ENV" == "DEV" ]; then
    echo "Starting project in Development mode as ENV IS  $PROJ_ENV"
    gradle bootRun
else
    echo "Starting project in Production mode as ENV IS  $PROJ_ENV"
    java  -jar spring_srvc.jar
fi
