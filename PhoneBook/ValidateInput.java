class ValidateInput {

    public boolean validateName(String name) {
        return name.matches("([a-zA-z]+(['-][a-zA-Z]+)*|[a-zA-z]+((\\s)*[a-zA-Z]+)*)");
    }

    public boolean validatePhone(String phone) {
        return phone.matches("[1-9]\\d{2}-\\d{3}-\\d{3}");
    }

    public boolean validateEmail(String email) {
        return email.matches(".+@.+\\.[a-z]+");
    }

    public boolean validateInputWay(String file) {
        return file.matches(".+[.txt]+");
    }
}
