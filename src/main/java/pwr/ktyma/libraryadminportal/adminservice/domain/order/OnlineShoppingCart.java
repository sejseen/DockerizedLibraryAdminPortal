package pwr.ktyma.libraryadminportal.adminservice.domain.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pwr.ktyma.libraryadminportal.adminservice.domain.User;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class OnlineShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private BigDecimal totalCost;

    @OneToMany(mappedBy = "onlineShoppingCart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<CartProduct> cartProductList;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;


    public OnlineShoppingCart() {
    }
}
