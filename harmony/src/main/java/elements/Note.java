package elements;

import lombok.Getter;

@Getter
public class Note {
    private int sound;
    private int name;
    private String note;

    public Note(int sound, int name, String note) {
        this.sound = sound;
        this.name = name;
        this.note = note;
    }

    @Override
    public String toString() {
        return note;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note1 = (Note) o;
        return name == note1.name;
    }
}