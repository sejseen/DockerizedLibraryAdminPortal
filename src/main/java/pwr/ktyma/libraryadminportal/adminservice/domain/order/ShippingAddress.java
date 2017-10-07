package pwr.ktyma.libraryadminportal.adminservice.domain.order;

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
public class ShippingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;

    private String Name;
    private String shippingStreet;
    private String shippingCity;
    private String shippingState;
    private String shippingCountry;
    private String shippingZipcode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
