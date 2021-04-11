# Kinesis POC - Producer

AWS Kinesis Producer Spring Application

In order to keep keys private, the application uses environment variables
to set AWS credentials and connection details.

- Requirements:
    - Environment Variables:
        - AWS_ACCESS_KEY
        - AWS_SECRET_KEY
        - AWS_REGION
        - KINESIS_STREAM_NAME
    - Sample Data File
    

On startup, the application streams over the provided file line by line
and produces every line to remote Kinesis Data Stream

    

