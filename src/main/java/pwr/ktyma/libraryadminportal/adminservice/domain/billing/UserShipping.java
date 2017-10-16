package pwr.ktyma.libraryadminportal.adminservice.domain.billing;

import lombok.Getter;
import lombok.Setter;
import pwr.ktyma.libraryadminportal.adminservice.domain.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class UserShipping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;

    private String userShippingName;
    private String userShippingStreet;
    private String userShippingCity;
    private String userShippingState;
    private String userShippingCountry;
    private String userShippingZipcode;
    private boolean userShippingDefault;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
