# Kinesis POC API


o GET http://{hostname}/{eventType}/average?from={timestamp}&to={timestamp} - average sample type value in interval
• Response:
{ "type": {string}, "value": {float} "processedCount": {int} //{number of processed events} }


• Request:
o GET http://{hostname}/average - average value by type
• Response:
[
{ "type": {string}, "value": {float} "processedCount": {int} //{number of processed events} },
…
]
