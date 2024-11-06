# Use MySQL base image
FROM mysql:8.3

# Set working directory inside the container
WORKDIR /tmp

# Copy SQL files into the Docker image
COPY world-db/*.sql /tmp/

# Ensure the employees.sql is in the correct directory and copy to MySQL's init folder
COPY world-db/world.sql /docker-entrypoint-initdb.d/
