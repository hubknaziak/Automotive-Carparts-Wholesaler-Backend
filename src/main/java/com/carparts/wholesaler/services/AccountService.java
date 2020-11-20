package com.carparts.wholesaler.services;

import com.carparts.wholesaler.dtos.AccountDto;
import com.carparts.wholesaler.models.Account;
import com.carparts.wholesaler.models.Client;
import com.carparts.wholesaler.repositories.AccountRepository;
import com.carparts.wholesaler.repositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.AbstractCollection;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final ClientRepository clientRepository;

    public Account addAccount(AccountDto accountDto) throws IllegalArgumentException{


        if(accountRepository.findByEmail(accountDto.getEmail())!= null) { //TUTAJ WYRZUCIC ODPOWIEDNI STATUS!!!
            throw new IllegalArgumentException("This email already exists in database:");
        }
        Client checkNIP;
        if(accountDto.getNip() != 0){
            checkNIP = clientRepository.findByNip(accountDto.getNip());
            if(checkNIP != null){
                throw new IllegalArgumentException("This NIP already exists in database:");
            }
        }
//        if(checkNIP != null && accountDto.getNip() != 0 ) { //TUTAJ WYRZUCIC ODPOWIEDNI STATUS!!!
//            throw new IllegalArgumentException("This NIP already exists in database:");
//        }

        Account account = new Account();

        account.setEmail(accountDto.getEmail());
        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
        account.setStatus("active");

        return accountRepository.save(account);
    }

    public Account updateAccount(AccountDto accountDto, int idAccount){
        Optional<Account> account = accountRepository.findById(idAccount);

        if(!accountDto.getPassword().equals("null")) account.get().setPassword(passwordEncoder.encode(accountDto.getPassword()));
        if(!accountDto.getEmail().equals("null")) account.get().setEmail(accountDto.getEmail());

        return accountRepository.save(account.get());
    }

    public int getAccountByEmail(String email){

        Account account = accountRepository.findByEmail(email);

        return account.getIdAccount();
    }

    public String getEmailByClientId(int idClient){
        Optional<Account> account = accountRepository.findById(idClient);

        return account.get().getEmail();
    }

    public Account disableAccount(int idAccount){
        Optional<Account> account = accountRepository.findById(idAccount);

        account.get().setStatus("deleted");
        accountRepository.save(account.get());

        return account.get();
    }
}
