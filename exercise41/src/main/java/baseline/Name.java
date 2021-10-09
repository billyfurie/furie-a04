package baseline;

public class Name {

    private String first;
    private String last;

    public Name(String first, String last) {
        // initialize variables

        // use these to format the name correctly
        // change all letters to lowercase
        StringBuilder firstName = new StringBuilder(first.toLowerCase());
        StringBuilder lastName = new StringBuilder(last.toLowerCase());
        // except the first letters are capitalized
        firstName.setCharAt(0, Character.toUpperCase(firstName.charAt(0)));
        lastName.setCharAt(0, Character.toUpperCase(lastName.charAt(0)));

        this.first = firstName.toString();
        this.last = lastName.toString();
    }

    // return the first name to the user
    public String getFirstName() {
        return first;
    }

    // return the last name to the user
    public String getLastName() {
        return last;
    }

    @Override
    public String toString() {
        // return the string in the format we plan to use
        return String.format("%s, %s", last, first);
    }
}
