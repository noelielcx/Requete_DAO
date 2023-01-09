package monprojet.dao;

import java.util.List;

import monprojet.dto.PaysPop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import monprojet.entity.City;
import monprojet.entity.Country;

// This will be AUTO IMPLEMENTED by Spring 

public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query (value = "select  sum(city.population)"
            + " from country inner join city on country.id = city.country_id"
            + " where country.id = :c_id", nativeQuery = true)
    public int sommePopulation(int c_id);

    @Query (value = "select country.name as nom, sum(city.population) as pop"
            + " from country inner join city on country.id = city.country_id"
            + " group by country.id", nativeQuery = true)

    public List<PaysPop> listePopulation();
}

