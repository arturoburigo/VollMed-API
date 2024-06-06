package med.voll.api.domain.users;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "Users")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Users {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String login;
    private  String password;
}
