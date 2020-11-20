package com.carparts.wholesaler;

import com.carparts.wholesaler.models.Account;
import com.carparts.wholesaler.models.Client;
import com.carparts.wholesaler.models.Employee;
import com.carparts.wholesaler.repositories.AccountRepository;
import com.carparts.wholesaler.repositories.ClientRepository;
import com.carparts.wholesaler.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AccountPrincipal implements UserDetails {

    private Account account;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    public AccountPrincipal(Account account, ClientRepository clientRepository, EmployeeRepository employeeRepository){
        this.account = account;
        this.clientRepository = clientRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        Optional<Client> client = clientRepository.findById(account.getIdAccount());
        if(client.isPresent()){
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
            authorities.add(authority);
        }
        Optional<Employee> employee = employeeRepository.findById(account.getIdAccount());
        if(employee.isPresent()){
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
            authorities.add(authority);
        }

        return authorities;
    }

    @Override
    public String getPassword() {
        return this.account.getPassword();
    }

    @Override
    public String getUsername() {
        return this.account.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       if(this.account.getStatus().equals("blocked") || this.account.getStatus().equals("deleted")){return false;}
       else return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if(this.account.getStatus().equals("active")){return true;}
        else return false;
    }

}
