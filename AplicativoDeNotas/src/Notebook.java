import java.util.List;

public class Notebook {
    private final String path = "notebooks/";
    private List<Note> notes;

    public String getPath() {
        return path;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    
    
}
