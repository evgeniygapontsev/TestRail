package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Project {
    int id;
    String name;
    String announcement;
    @Expose
    @SerializedName("show_announcement")
    boolean showAnnouncement;
    @Expose
    @SerializedName("suite_mode")
    int suiteMode;
    String url;
}
