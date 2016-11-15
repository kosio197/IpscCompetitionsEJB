package bg.softuni.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import bg.softuni.entity.CountryModel;

@Stateless
public class CountryServiceImpl implements CountryService {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<String> getAllCountries() {
        List<String> result = new ArrayList<>();
        Query q = em.createQuery("select c from CountryModel c");
        @SuppressWarnings("unchecked")
        List<CountryModel> models = q.getResultList();
        for (CountryModel countryModel : models) {
            result.add(countryModel.getName());
        }

        return result;
    }

}
