# sharedCallendar

# startup

from project main directory run:

docker-compose up

dockerized app is running on port 8081
local app is running on port 8080

# curls for testing:

curl -X POST -H "Content-Type: application/json" \
-d '{"name": "Fred"}' \
http://localhost:8081/users

curl -X POST -H "Content-Type: application/json" \
-d '{"userId":"1", "name": "call availability"}' \
http://localhost:8081/calendars

curl -X POST -H "Content-Type: application/json" \
-d '{"userId":"1", "calendarId":"1", "startTime":"2022-01-09T18:00:00", "endTime":"2022-01-09T20:00:00" }' \
http://localhost:8081/timeslots


