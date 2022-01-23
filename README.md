# sharedCallendar

few useful commands:

# setup for docker postgers

docker exec -it dev-postgres psql -U postgres

curls for testing:

curl -X POST -H "Content-Type: application/json" \
-d '{"name": "Fred"}' \
http://localhost:8080/users

curl -X POST -H "Content-Type: application/json" \
-d '{"userId":"1", "name": "call availability"}' \
http://localhost:8080/calendars

curl -X POST -H "Content-Type: application/json" \
-d '{"userId":"1", "calendarId":"1", "startTime":"2022-01-09T18:00:00", "endTime":"2022-01-09T20:00:00" }' \
http://localhost:8080/timeslots


