package SerializationBody;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BodyPostProjectSettings {
    private int startingNumber;
    private String template;
    private String name;
    private String key;
    private String iconUrl;
    private String description;
    private boolean pinned;
    private boolean isDemo;
}
