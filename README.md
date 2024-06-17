# EduCostStatQuery

**What is the Project About**
This project focuses on practicing (1) RPC (Remote Procedure Call) communication for resources and services, (2) data operations on MongoDB, a NoSQL database, and (3) the implementation of aggregation pipelines for data processing. It utilizes a public dataset from the National Center of Education Statistics Annual Digest, USA, which provides statistics on average undergraduate tuition and fees, as well as room and board rates for full-time students in degree-granting postsecondary institutions.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Tools and Technologies Used**

- Programming Languages: Java
- Frameworks and Libraries: gRPC , Protocol Buffers (protobuf)
- Database: MongoDB (cloud service)
- Messaging and RPC: gRPC
- Data Format: Protocol Buffers for defining data communication interfaces
- Configuration Management: pom.xml for dependency management


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Solution Explanation**

- Task 1: MongoDB Data Storage and Operation
  
    1. Data Storage:
    Create a MongoDB collection named EduCostStat to store the dataset.
    Read the data from the downloaded file (Excel or CSV) and store it in the MongoDB online cluster.
    
    2. Data Access Objects:
    Develop data access objects in Java for different queries, ensuring no duplication of queries as new documents.

- Queries:

    1. Query the cost given specific year, state, type, length, and expense; save the result in EduCostStatQueryOne.
    2. Query the top 5 most expensive states given a year, type, and length; save the result in EduCostStatQueryTwo.
    3. Query the top 5 most economic states given a year, type, and length; save the result in EduCostStatQueryThree.
    4. Query the top 5 states with the highest growth rate of overall expense given a range of past years; save the result in EduCostStatQueryFour.
    5. Aggregate region’s average overall expense for a given year, type, and length; save the result in EduCostStatQueryFive.
   
- Task 2: Data Communication Interface Definition and Service Implementation
  
    1. Protocol Buffers Definition:
    Define a Protocol Buffers file to represent the request, response, and service for each query.
    
    2.gRPC Services:
    Develop Java programs for each service defined in the Protocol Buffers file, implementing them as gRPC services. These services invoke the corresponding data access object classes developed in Task 1.
    
    3.gRPC Client and Server:
    Develop gRPC client and server (or gateway) code to facilitate RPC calls for the five queries defined in Task 1.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**Result**

The project successfully implements a distributed system architecture using gRPC for RPC communication and MongoDB for data storage and operations. 

Key outcomes include:

- Efficient storage and querying of educational cost statistics in MongoDB.
- Seamless RPC communication between clients and servers using gRPC.
- Clear and well-documented architecture with Protocol Buffers definitions for data communication.
- Screenshots and Documentation
- The final report includes an updated architecture diagram, explanations of each component's function, and solutions to Tasks 1 and 2, with necessary screenshots.





COEN 6731 Winter 2023 Assignment Two / Assign-2 DSS
