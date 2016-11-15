package bg.softuni.service;

import java.util.List;

import javax.ejb.Local;

@Local
public interface CountryService {

    List<String> getAllCountries();
}
