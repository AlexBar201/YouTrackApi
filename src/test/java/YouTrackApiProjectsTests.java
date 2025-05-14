import DeserializationBody.DeserializationBodyPostProjectSettings;
import DeserializationBody.PostTheFinalRequest.DeserializationBodyPostTheFinalRequest;
import SerializationBody.Leader;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class YouTrackApiProjectsTests {

    static YouTrackApiProjects youTrack = new YouTrackApiProjects();

    @BeforeAll
    static void globalSetUp(){
        youTrack.setUp();
    }

    @Nested
    class PostAndPointsTests {

        @Nested
        class PositiveTests{

            @ParameterizedTest
            @CsvFileSource(resources = "/FirstAndPointTestData.csv", numLinesToSkip = 1)
            @DisplayName("Позитивная проверка первой ручки из трёх, для создания проекта")
            @io.qameta.allure.Description("Отправляем валидные имя проекта и его идентификатор, возвращается статус код \"200 OK\", а так же пустой json объект, при этом после теста ничего удалять не нужно так, как после этого запроса ничего не создаётся")
            public void postNameAndShortNameTests(String name, String shortName){
                Response firstAndPoint = youTrack.postNameAndShortName(name, shortName);
                firstAndPoint
                        .then()
                        .statusCode(200)
                        .body(equalTo("{}"));
            }

            //ВАЖНО!!! Чтобы данный тест проходил нужно перед каждым запуском теста задавать уникальные name и key в csv файле, так как мы не знаем ручку для удаления заданных настроек, при этом по факту проект еще не создан, по этому мы не можем удалить отправленное известным DELETE запросом
            @ParameterizedTest
            @CsvFileSource(resources = "/TwoAndPointTestData.csv", numLinesToSkip = 1)
            @DisplayName("Позитивная проверка второй ручки из трёх, для создания проекта")
            @io.qameta.allure.Description("Отправляем будущие настройки проекта, ожидаем статус код \"200 OK\", в ответе получаем id, который нужен для третьего запроса на создание")
            public void postProjectSettingsTests(int startingNumber, String template, String name, String key, String iconUrl, String description, boolean pinned, boolean isDemo){
                Response twoAndPoint = youTrack.postProjectSettings(startingNumber, template, name, key, iconUrl, description, pinned, isDemo);
                twoAndPoint
                        .then()
                        .statusCode(200)
                        .body("id", notNullValue());
            }
        }

        @Nested
        class NegativeTests{

            @ParameterizedTest
            @CsvFileSource(resources = "/FirstAndPointTestDataNegative.csv", numLinesToSkip = 1)
            @DisplayName("Негативная проверка первой ручки из трёх, для создания проекта")
            @io.qameta.allure.Description("Отправляем имя проекта и его идентификатор(один из параметров невалидный), возвращается статус код \"400 Bad Request\", а так же json с описание ошибки, при этом после теста ничего удалять не нужно так, как после этого запроса ничего не создаётся, так как тест параметризован и для каждого невалидного типа данных сообщение об ошибке разное этот параметр мы проверять не будем")
            public void postNameAndShortNameNegativeTests(String name, String shortName){
                Response firstAndPoint = youTrack.postNameAndShortName(name, shortName);
                firstAndPoint
                        .then()
                        .statusCode(400);
            }
            //Тут можно добавить ещё тесты на вторую ручку, передав json с невалидными данными, но я уже слишком долго пишу это практическое...=)))
        }
    }

    @Nested
    class CreateProjectTests{

        @Nested
        class PositiveTests{

            //Вообще я понимаю, что один тест = одна проверка, но в случае с этим тестом не могу догнать как можно так реализовать, будем считать, что это шаг. Возможно стоило это всё провернуть в классе YouTrackApiProjects, а в тесте вызвать один метод передав все нужные данные
            @Test
            @DisplayName("Позитивная проверка всей цепочки запросов на создание проекта")
            @Description("Если вся цепочка запросов отправлена правильно возвращается статус код \"200 OK\", в ответе приходит json из которого можно вытащить id, нужный для удаления проекта")
            public void createProjectPositiveTest(){

                //Тестовые данные
                String iconURL = "/hub/api/rest/projects/fa03c1b9-98e4-4585-b05b-6d03aba862fb/icon?etag=MjUtMTAwOA%3D%3D";
                String name = "Project4567";
                String shortNameAndKey = "PJT";

                //Отправляем наш первый пост запрос с именем и идентификатором
                youTrack.postNameAndShortName(name, shortNameAndKey);

                //Отправляем наш второй пост запрос с настройками проекта, затем десериализуем полученный ответ
                DeserializationBodyPostProjectSettings getRingID = youTrack.postProjectSettings(1, "default", name, shortNameAndKey, iconURL, "", true, false)
                        .then()
                        .statusCode(200)
                        .extract()
                        .as(DeserializationBodyPostProjectSettings.class);

                //Создаем объект leader нужный для сериализации json который используется в финальном пост запросе на создание проекта
                Leader leader = new Leader("db67e985-8a88-4442-876e-fb970ef46874");

                //Отправляем финальный запрос на создание проекта
                DeserializationBodyPostTheFinalRequest finalPost = youTrack.postTheFinalRequest(getRingID.getId(), 1, false, name, shortNameAndKey, "", leader)
                        .then()
                        .statusCode(200)
                        .body("id", notNullValue())
                        .extract()
                        .as(DeserializationBodyPostTheFinalRequest.class);

                //Удаляем созданный проект, чтобы не оставлять после себя мусор
                youTrack.deleteYouTrackProject(finalPost.getId())
                        .then()
                        .statusCode(200);
            }
        }

        @Nested
        class NegativeTests{
            //Тут по-хорошему нужно добавить негативные тесты на создание проекта, но я уже устал от этого практического...=)))
        }
    }
}
