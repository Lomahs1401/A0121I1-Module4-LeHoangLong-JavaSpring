package codegym.repository;

import codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogRepository extends CrudRepository<Blog,Integer> {

    Page<Blog> findAllByTitleContaining(String name,Pageable pageable);

    Page<Blog> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM blog WHERE category_id = :id",nativeQuery = true)
    Page<Blog> findAllByCategory(Pageable pageable,@Param("id") int id);
}