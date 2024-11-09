package com.backend.empowerpro.auth.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "employee")
@Builder
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "first_name", length = 50, nullable = false)
    @NotBlank(message = "firstname Cannot be Empty")
    private String firstName;

    @Column(name = "last_name", length = 50, nullable = false)
    @NotBlank(message = "lastname Cannot be Empty")
    private String lastName;

    @Column(name = "address", length = 500, nullable = false)
    private String address;

    @Column(name = "email", length = 50, nullable = false)
    @Email
    @NotBlank(message = "Email Cannot be Empty")
    private String email;

    @Column(name = "phone_number", nullable = false, unique = true)
//    @NotBlank(message = "PhoneNumber Cannot be Empty")
    private Long phoneNumber;

    @Column(name = "work_title", length = 50, nullable = false)
    @NotBlank(message = "workTitle Cannot be Empty")
    private String workTitle;

    @Enumerated(EnumType.STRING)
    private EmployeeRole role;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    @NotBlank(message = "Username Cannot be Empty")
    private String username;

    @Column(name = "password", nullable = false)
    @NotBlank(message = "password Cannot be Empty")
    @Size(min = 8 ,message = "Password Must be more than 5 Characters")
    private String password;

    @Column(name = "summary", length = 50000)

    private String summary;

    @Column(name = "skills", length = 50000)

    private String skills;

    @Column(name = "experiences", length = 50000)
    private String experiences;

    @OneToOne(mappedBy = "employee")
    private RefreshToken refreshToken;

    private String profile;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
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
        return true;
    }
}


