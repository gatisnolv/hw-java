# Homework solution in Java

# Description

This is my homework solution in Java/ Spring Boot. I have completed all listed requirements. The application bundles data from the data source within the container image as a default / fallback, but it also supports updating the data by calling an endpoint for this purpose. For demo purposes the bundled data differs from the current (as of December 12) data in the data source in the following manner - it omits the first row of data. This should help demonstrate the update functionality.


# Dependencies

The project assumes only `docker build` and `docker run`, as the project is built from source files as part of creating the container image.


# Running the project

The server will run on `localhost:8080`, in top level dir execute (builds and runs the conainer image):

`docker run --rm -it -p 8080:8080 $(docker build -q .)`


# Main endpoints

`GET /station` - returns all stations data in JSON

- Example: `curl -H 'X-API-Key: very-secret-preshared-key-123' localhost:8080/station`


`GET /station/{STATION_ID}` - returns data for a station with the given STATION_ID in JSON

- Example: `curl -H 'X-API-Key: very-secret-preshared-key-123' localhost:8080/station/RIJE99PA`


`POST /station` - performs an update of stations data, making it available for retrieval by the previous two endpoints

- Example: `curl -X POST -H 'X-API-Key: very-secret-preshared-key-123' localhost:8080/station`


# OpenAPI specification

Available at `http://localhost:8080/v3/api-docs`


# Request authorization

Requests to the API are authorized with an API key in the request header.
In the request header `X-API-Key` use the value `very-secret-preshared-key-123`.


# Testing

I have not written any unit tests, as I find that there's not much to unit test in my implementation.


# Bonus: Running the project with a more minimal base image and a custom minimal JRE. (Uses a trimmed-down runtime base image (Debian) which itself does not come with a JRE. The custom JRE is produced using the JLink tool)

In top level dir execute:
`docker run --rm -it -p 8080:8080 $(docker build -q --file Dockerfile-jlink .)`
