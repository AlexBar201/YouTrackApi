import SerializationBody.BodyPostNameAndShortName;
import SerializationBody.BodyPostProjectSettings;
import SerializationBody.BodyPostTheFinalRequest;
import SerializationBody.Leader;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class YouTrackApiProjects {

    ConfigReader configReader = new ConfigReader();

    public void setUp(){
        RestAssured.baseURI = configReader.getBaseUri();
    }

    @Step("Отправляем наименование проекта и его идентификатор")
    public Response postNameAndShortName(String name, String shortName){
        BodyPostNameAndShortName json = new BodyPostNameAndShortName(name, shortName);
        return RestAssured
                .given()
                .basePath(configReader.getEndPointOne())
                .queryParam(configReader.getEndPointOneQueryParamName(), configReader.getEndPointOneQueryParamValue())
                .header("Authorization", configReader.getToken())
                .header("Content-Type", "application/json")
                .body(json)
                .relaxedHTTPSValidation()
                .when()
                .post();
    }

    @Step("Отправляем настройки проекта")
    public Response postProjectSettings(int startingNumber, String template, String name, String key, String iconUrl, String description, boolean pinned, boolean isDemo){
        BodyPostProjectSettings json = new BodyPostProjectSettings(startingNumber, template, name, key, iconUrl, description, pinned, isDemo);
        return RestAssured
                .given()
                .basePath(configReader.getEndPointTwo())
                .queryParam(configReader.getEndPointTwoQueryParamName(), configReader.getEndPointTwoQueryParamValue())
                .header("Authorization", configReader.getToken())
                .header("Content-Type", "application/json")
                .body(json)
                .relaxedHTTPSValidation()
                .when()
                .post();
    }

    @Step("Завершающий запрос на создание проекта")
    public Response postTheFinalRequest(String ringId, int startingNumber, boolean createContent, String name, String shortName, String description, Leader leader){
        BodyPostTheFinalRequest json = new BodyPostTheFinalRequest(ringId, startingNumber, createContent, name, shortName, description, leader);
        return RestAssured
                .given()
                .basePath(configReader.getEndPointThree())
                .queryParam(configReader.getEndPointThreeQueryParamNameOne(), configReader.getEndPointThreeQueryParamValueOne())
                .queryParam(configReader.getEndPointThreeQueryParamNameTwo(), configReader.getEndPointThreeQueryParamValueTwo())
                .header("Authorization", configReader.getToken())
                .header("Content-Type", "application/json")
                .body(json)
                .relaxedHTTPSValidation()
                .when()
                .post();
    }

    @Step("Создание проекта")
    public Response createYouTrackProject(){
        //Это будет в тестовом классе
    }

    @Step("Удаление проекта")
    public Response deleteYouTrackProject(){

    }
}
