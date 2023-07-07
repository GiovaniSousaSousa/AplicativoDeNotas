import java.time.LocalDate;
import java.time.LocalDateTime;

public class Note {
    private String title;
    private String content;
    private LocalDate dateCreated;
    private LocalDateTime lastModified;

    public Note(String title, String content, LocalDate dateCreated, LocalDateTime lastModified) {
        this.title = title;
        this.content = content;
        this.dateCreated = dateCreated;
        this.lastModified = lastModified;
    }
    public Note() {
    }
   
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "Note{" + "title=" + title + ", content=" + content + ", dateCreated=" + dateCreated + ", lastModified=" + lastModified + '}';
    }
    
    
    
}
