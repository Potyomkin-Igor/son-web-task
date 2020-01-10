Application launch steps:
1. Open a terminal, and go to the project root directory.
2. Run command "mvn clean package".
3. Make sure that you have Docker and then run command "docker build -t son-web-task .".
4. Run command "docker run -p 8080:8080 son-web-task".

The task was solved in two versions: 
1. Using the GitHub API.
2. Send direct http requests using (RestTemplate).