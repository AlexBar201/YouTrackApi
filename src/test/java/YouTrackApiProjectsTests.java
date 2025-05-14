import io.restassured.response.Response;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class YouTrackApiProjectsTests {

    @Nested
    class PostAndPointTests{
        YouTrackApiProjects youTrack = new YouTrackApiProjects();
        @Test
        public void testEndPoint(){
            youTrack.setUp();
            Response firstAndPoint = youTrack.postNameAndShortName("Project1488", "wer");
            firstAndPoint.then().statusCode(200);
        }
    }

    @Nested
    class CreateProjectTests{

    }
}
