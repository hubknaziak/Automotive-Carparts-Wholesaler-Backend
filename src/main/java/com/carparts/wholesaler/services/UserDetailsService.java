package com.carparts.wholesaler.services;

import com.carparts.wholesaler.AccountPrincipal;
import com.carparts.wholesaler.models.Account;
import com.carparts.wholesaler.models.Client;
import com.carparts.wholesaler.repositories.AccountRepository;
import com.carparts.wholesaler.repositories.ClientRepository;
import com.carparts.wholesaler.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);

        if(account == null){
            throw new UsernameNotFoundException(email);
        }
        return new AccountPrincipal(account, clientRepository, employeeRepository);
    }
}
