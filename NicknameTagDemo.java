final class NameTag {
    private final String firstName;
    private final String lastNameInitial;

    public NameTag(String fullName) {
        if (fullName == null || !fullName.contains(" ")) {
            this.firstName = "Unknown";
            this.lastNameInitial = "";
        } else {
            String[] parts = fullName.trim().split(" ");
            this.firstName = parts[0];
            this.lastNameInitial = parts[1].substring(0, 1) + ".";
        }
    }

    public String getNickname() {
        return firstName + " " + lastNameInitial;
    }
}

public class NicknameTagDemo {

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        System.out.println("Nickname: " + tag.getNickname());
    }
}