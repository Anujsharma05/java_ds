package reflection.section7.repeatable_annotations.exercise;

public class Main {
  public static void main(String[] args) throws Throwable {
    User user = new User("John Doe", Role.CLERK);
    CompanyDataStore companyDataStore = new CompanyDataStore(user);
    companyDataStore.readAccounts(new String[] {"1"});
  }
}
