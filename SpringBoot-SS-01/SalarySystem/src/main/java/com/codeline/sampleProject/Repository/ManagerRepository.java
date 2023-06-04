package com.codeline.sampleProject.Repository;

import com.codeline.sampleProject.Models.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {

    @Query("SELECT * FROM Manager WHERE teamName=:nameOfTeam")
    Manager getManagerByTeamName(@Param("nameOfTeam") String teamName);
}
