
### REQUIREMENTS
- docker

###  HOW TO USE THIS PROJECT

- git clone https://github.com/RandyHBH/airports-reviews.git
- cd airports-reviews
- run `mvnw clean package`
- run `docker-compose up -d` 
- run the next `curl` command to load the example data to the database
```bash
  curl --location --request POST 'http://localhost:8080/api/load/csv' \
  --form 'file=@"./airport-reviews.csv"'
  ```
- open http://localhost:8080/swagger-ui.html to navigate the swagger api easily and perform the other actions 

### Just in case here there are some examples
- Get all stats: 
```bash 
curl --location --request GET 'http://localhost:8080/api/all/stats'
```

- Get airport stats:
```bash 
curl --location --request GET 'http://localhost:8080/api/aberdeen-airport/stats'
```

-Get airport reviews
```bash
curl --location --request GET 'http://localhost:8080/api/aberdeen-airport/reviews'
```
