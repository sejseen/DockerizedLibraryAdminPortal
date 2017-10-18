package pwr.ktyma.libraryadminportal.adminservice.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pwr.ktyma.libraryadminportal.adminservice.domain.authorise.Authorithy;
import pwr.ktyma.libraryadminportal.adminservice.domain.authorise.UserRole;
import pwr.ktyma.libraryadminportal.adminservice.domain.billing.UserPayment;
import pwr.ktyma.libraryadminportal.adminservice.domain.billing.UserShipping;
import pwr.ktyma.libraryadminportal.adminservice.domain.order.OnlineShoppingCart;
import pwr.ktyma.libraryadminportal.adminservice.domain.order.Order;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;
    private String username;
    private String password;

    @Column(name = "email", nullable = false, updatable = false)
    private String email;
    private String firstName;
    private String lastName;
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserShipping> userShippingList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<UserPayment> userPaymentsList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<UserRole> userRoles = new HashSet<>();

    private boolean enabled = true;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private OnlineShoppingCart shoppingCart;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Authorithy> authorithies = new HashSet<>();
        userRoles.forEach(user -> authorithies.add(new Authorithy(user.getRole().getName())));

        return authorithies;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }


}
