Run below commands from command prompt in below order

1. docker-compose up(from directory of the file)
2. start the spring app by running the main class: SpringBootCassandraDemoApplication
3. verify cassandra container is running: docker ps
4. get the container id of the cassandra container and run: docker exec -it <containerid> bash
5. cqlsh
6. Create a keyspace in cassandra: CREATE KEYSPACE mykeyspace WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};
7. verify keyspace created: describe keyspaces; 
8. Create table in the above keyspace:
    a) use mykeyspace;
    b) CREATE TABLE Product(id int PRIMARY KEY, name TEXT);
9. verify table created: describe tables
10. now run POST/GET operations from Postman to verify results