package pwr.ktyma.libraryadminportal.adminservice.domain.billing;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class UserBilling {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;

    private String userBillingName;
    private String userBillingStreet;
    private String userBillingCity;
    private String userBillingState;
    private String userBillingCountry;
    private String userBillingZipcode;

    @OneToOne(cascade = CascadeType.ALL)
    private UserPayment userPayment;
}
