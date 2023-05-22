# IQ Challenge API
An API for IQ Challenge minigame


## Project Structure

```
src\main\java\hdang09
                 |--controllers\              # Route controllers (controller layer)
                 |--entities\                 # JPA entities (data layer)
                 |--repositories\             # Class that interact with database
                 |--services\                 # Business logic (service layer)
                 |--IqApp.java                # App entry point
                 |--ServletInitializer.java   # Config the servlet context
```

### API Endpoints

List of available routes:

**User routes**:\
`POST /user/register`                 - register\
`GET  /user/start/{name}/{studentID}` - start to do the test\
`PUT  /user/end`                      - submit the test\
`GET  /user/scoreboard`               - see the scoreboard\
`GET  /user/{studentID}`              - get the student result\

**Question routes**:\
`GET    /question` - get all question\
`GET    /question/{questionId}` - get specific quesion\
`POST   /question/create` - create question\
`DELETE /question/delete` - delete question


