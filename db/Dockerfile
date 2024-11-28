FROM mysql:8.3

#set working directory
WORKDIR /tmp



COPY ./world-db/world.sql /docker-entrypoint-initdb.d

ENV MYSQL_ROOT_PASSWORD example

