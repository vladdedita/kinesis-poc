# Kinesis POC - Producer

AWS Kinesis Producer Spring Application

On startup, the application streams over a provided resources file (defined in application.yaml) line by line
and produces every line to remote Kinesis Data Stream

Data Format:

"timestamp,type,value"

Ex.

"1567366060,mars,65.98"

    

