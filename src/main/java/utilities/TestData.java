package utilities;

public class TestData {

    public Login login;
    public Search search;

    public static class Login {
        public Credentials valid;
        public Credentials invalid;
    }

    public static class Credentials {
        public String username;
        public String password;
    }

    public static class Search {
        public String query;
    }
}
