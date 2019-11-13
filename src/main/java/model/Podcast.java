package model;

public class Podcast {
    private String Title;
    private String Language;
    private String Description;
    private String link;
    private String Duration;
    private String Summary;
    private String PubDate;
    public Podcast(String title, String language, String description, String link, String duration, String summary, String pubDate) {
        Title = title;
        Language = language;
        Description = description;
        this.link = link;
        Duration = duration;
        Summary = summary;
        PubDate = pubDate;
    }

    public Podcast() {
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getSummary() {
        return Summary;
    }

    public void setSummary(String summary) {
        Summary = summary;
    }

    public String getPubDate() {
        return PubDate;
    }

    public void setPubDate(String pubDate) {
        PubDate = pubDate;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "Title='" + Title + '\'' +
                ", Language='" + Language + '\'' +
                ", Description='" + Description + '\'' +
                ", link='" + link + '\'' +
                ", Duration='" + Duration + '\'' +
                ", Summary='" + Summary + '\'' +
                ", PubDate='" + PubDate + '\'' +
                '}';
    }
}
//Declineism