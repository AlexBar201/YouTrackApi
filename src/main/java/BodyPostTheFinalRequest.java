import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodyPostTheFinalRequest {
    private String ringId;
    private int startingNumber;
    private boolean createContent;
    private String name;
    private String shortName;
    private String description;
    private Leader leader;
}
