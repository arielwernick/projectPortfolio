package sepractice;
public class Patron {


    private String firstName;
    private String lastName;
    private String idNumber;
    private String emailAddress;
    private String phoneNumber;
   private String password;


    public Patron(String firstName, String lastName, String emailAddress, String password, String phoneNumber,long idNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = setIDNumber(idNumber);
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        setPassword(password);
    }



    private String setIDNumber(long number){
        String idNumberMaker = "800"+number;
        String forReturn = idNumberMaker;
        return forReturn;
    }

    public String getIdNumber(){
        return this.idNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getPassword() { return this.password;}

    public void setPassword(String password){
        this.password = password;
    }


    public String getPhoneNumber() {
        return this.phoneNumber;
    }


}
