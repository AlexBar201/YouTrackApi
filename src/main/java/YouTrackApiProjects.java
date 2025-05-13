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
                .body("{\"name\":\"project1488\",\"shortName\":\"PJC\"}")
                .relaxedHTTPSValidation()
                .when()
                .post();
    }

    @Step("Отправляем настройки проекта")
    public Response postProjectSettings(){

    }

    @Step("Завершающий запрос на создание проекта")
    public Response postTheFinalRequest(){

    }

    @Step("Создание проекта")
    public Response createYouTrackProject(){

    }

    @Step("Удаление проекта")
    public Response deleteYouTrackProject(){

    }
}
