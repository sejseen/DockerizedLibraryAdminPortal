package pwr.ktyma.libraryadminportal.adminservice.domain.billing;

import lombok.Getter;
import lombok.Setter;
import pwr.ktyma.libraryadminportal.adminservice.domain.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class UserPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private String type;
    private String CardName;
    private String cardNumber;
    private int expiryMonth;
    private int expiryYear;
    private int cvc;
    private String holderName;
    private boolean defaultPayment;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userPayment")
    private UserBilling userBilling;

}
