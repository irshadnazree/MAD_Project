package ftmk.bitp3453.OrderApp;

import java.io.Serializable;

public class userDetails implements Serializable {


    private String name;
    private String phoneNo;

    public userDetails(String name, String phoneNo) {
        this.name = name;
        this.phoneNo = phoneNo;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String tableNo) {
        this.phoneNo = phoneNo;
    }
}

