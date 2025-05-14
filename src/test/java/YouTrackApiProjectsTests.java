import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class YouTrackApiProjectsTests {

    static YouTrackApiProjects youTrack = new YouTrackApiProjects();

    @BeforeAll
    static void globalSetUp(){
        youTrack.setUp();
    }

    @Nested
    class PostAndPointsTests {
        @Test
        public void testEndPoint(){
            Response firstAndPoint = youTrack.postNameAndShortName("Project1488", "wer");
            firstAndPoint.then().statusCode(200);
        }
    }

    @Nested
    class CreateProjectTests{

    }
}
