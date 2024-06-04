package fr.eni.java.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import fr.eni.java.bean.Region;

public interface RegionDAO extends JpaRepository<Region, Integer> {

}
