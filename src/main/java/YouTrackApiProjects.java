import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class YouTrackApiProjects {

    private final String BASE_URI;
    private final String END_POINT_ONE;
    private final String END_POINT_TWO;
    private final String END_POINT_THREE;
    private final String END_POINT_FOUR;

    public YouTrackApiProjects(String BASE_URI, String END_POINT_ONE, String END_POINT_TWO, String END_POINT_THREE, String END_POINT_FOUR){
        this.BASE_URI = BASE_URI;
        this.END_POINT_ONE = END_POINT_ONE;
        this.END_POINT_TWO = END_POINT_TWO;
        this.END_POINT_THREE = END_POINT_THREE;
        this.END_POINT_FOUR = END_POINT_FOUR;
    }

    public void setUp(){
        RestAssured.baseURI = BASE_URI;
    }

    @Step("Отправляем наименование проекта и его идентификатор")
    public Response postNameAndShortName(){

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
