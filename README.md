# kinesis-poc

Spring Cloud Streaming Application using Kinesis Data Stream using spring-cloud-stream-binder-kinesis


Dependencies:

- Mongodb - provided docker-compose in this repo for fast local setup
- AWS Kinesis Datastream 


In order to keep keys private, the application uses environment variables to set AWS credentials and connection details.

- Requirements:
    - Environment Variables:
        - AWS_ACCESS_KEY
        - AWS_SECRET_KEY
        - AWS_REGION
        - KINESIS_STREAM_NAME

Modules:
- Producer - has been implemented to facilitate stream population - can be ignored if data is produced streaming in kinesis by other means
- Consumer - consumes and saves data to mongodb
- Api - REST access to saved data in mongodb
    


