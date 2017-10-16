package pwr.ktyma.libraryadminportal.adminservice.domain.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;

    private String billingName;
    private String billingStreet;
    private String billingCity;
    private String billingState;
    private String billingCountry;
    private String billingZipcode;

    @OneToOne
    private Order order;

    public BillingAddress() {
    }
}
