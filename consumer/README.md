# Kinesis POC Consumer

Spring Cloud Stream Kinesis Consumer 

Consumes messages from Kinesis Data Stream (**KINESIS_STREAM_NAME**)


Data Format:

"timestamp,type,value"

Ex.

"1567366060,mars,65.98"


The consumed data is bucketed in mongodb as follows:
 - "time" - time series bucket - all samples with timestamp between start / end - bucketed by a predefined bucket_size to reduce overall document number and easier  querying
 - "average" - total value and processed count for every sample type 
 
