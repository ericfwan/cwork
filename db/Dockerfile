# Use MySQL base image
FROM mysql:8.3

# Set working directory inside the container
WORKDIR /tmp

# Copy SQL files into the Docker image
COPY world-db/*.sql /tmp/

# Ensure world.sql is copied into MySQL's init folder
COPY world-db/world.sql /docker-entrypoint-initdb.d/

# Set the root password
ENV MYSQL_ROOT_PASSWORD example
