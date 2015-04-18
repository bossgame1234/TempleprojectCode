package camt.se331.templeProject.repository;

import camt.se331.templeProject.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dell on 1/4/2558.
 */
public interface NewsRepository extends JpaRepository<News,Long> {
}
