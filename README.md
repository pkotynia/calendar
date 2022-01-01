# sharedCallendar

few useful commands:

# setup for docker postgers

docker run -d \
--name dev-postgres \
-e POSTGRES_PASSWORD=admin \
-p 54320:5432 \
postgres

docker exec -it dev-postgres psql -U postgres

CREATE TABLE calendars (
id serial PRIMARY KEY,
name VARCHAR
);


curls for testing:

curl -X POST -H "Content-Type: application/json" \
-d '{"name": "call availability"}' \
http://localhost:8080/calendars
