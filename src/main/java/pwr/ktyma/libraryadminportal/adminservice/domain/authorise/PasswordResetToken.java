package pwr.ktyma.libraryadminportal.adminservice.domain.authorise;

import lombok.Getter;
import lombok.Setter;
import pwr.ktyma.libraryadminportal.adminservice.domain.User;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
public class PasswordResetToken {

    private static final int EXPIRATION = 24 * 60;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    private String token;

    private Date expirationDate;

    public PasswordResetToken(String token, User user) {
        this.token = token;
        this.user = user;
    }

    public PasswordResetToken() {
    }

    private Date calculateExpirationDate(int expirationTimeInMinutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTimeInMinutes);
        return new Date(calendar.getTime().getTime());
    }

    public void updateToken(final String token, int expirationTimeInMinutes) {
        this.token = token;
        //Default should be EXPIRATION, but for test make parametrized function
        this.expirationDate = calculateExpirationDate(expirationTimeInMinutes);
    }

    public PasswordResetToken(User user, String token, Date expirationDate) {
        super();

        this.user = user;
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public static int getEXPIRATION() {
        return EXPIRATION;
    }

    @Override
    public String toString() {
        return "PasswordResetToken{" +
                "id=" + id +
                ", user=" + user +
                ", token='" + token + '\'' +
                ", expirationDate=" + expirationDate +
                '}';
    }
}