package pwr.ktyma.libraryadminportal.adminservice.domain.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pwr.ktyma.libraryadminportal.adminservice.domain.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private int quantity;
    private BigDecimal subtotal;

    @OneToOne
    private Book book;

    @OneToMany(mappedBy = "cartProduct")
    @JsonIgnore
    List<BookToCartItem> bookToCartItemList;

    @ManyToOne
    @JoinColumn(name = "online_shopping_cart_id")
    private OnlineShoppingCart onlineShoppingCart;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;


}
