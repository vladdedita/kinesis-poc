# Kinesis POC API

Runs on port 9000

o GET 
http://localhost:9000/{eventType}/average?from={timestamp}&to={timestamp} - average sample type value in interval
• Response:

{ "type": {string}, "value": {float} "processedCount": {int} //{number of processed events} }



o GET http://localhost:9000/average - average value by type
• Response:
[
{ "type": {string}, "value": {float} "processedCount": {int} //{number of processed events} },
…
]
