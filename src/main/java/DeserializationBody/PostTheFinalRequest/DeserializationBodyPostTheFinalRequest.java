package DeserializationBody.PostTheFinalRequest;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeserializationBodyPostTheFinalRequest {
    private boolean fieldsSorted;
    private boolean isDemo;
    private boolean template;
    private String shortName;
    private String ringId;
    private String issuesUrl;
    private boolean hasArticles;
    private String iconUrl;
    private boolean archived;
    private boolean restricted;
    private ProjectType projectType;
    private String query;
    private Plugins plugins;
    private boolean pinned;
    private String name;
    private String id;
    private String $type;
}
