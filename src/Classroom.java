import java.util.Objects;

public class Classroom {
    private int room;
    private int building;

    public Classroom(int room, int building) {
        this.room = room;
        this.building = building;
    }

    public int getRoom() {
        return room;
    }

    public int getBuilding() {
        return building;
    }

    public String getClassroomFullAddress() {
        return "Building " + building + ", Room " + room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return room == classroom.room && building == classroom.building;
    }

    @Override
    public int hashCode() {
        return Objects.hash(room, building);
    }

    @Override
    public String toString() {
        return getClassroomFullAddress();
    }
}
