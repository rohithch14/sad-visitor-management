// Defines a package in which the classes are
package com.visitormanagement.repository;

// Importing the necessary classes from the Spring framework
import com.visitormanagement.model.VisitorTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// @Repository annotation is used to indicate that the class provides the mechanism for storage, retrieval, search, update and delete operation on objects.
@Repository
public interface VisitorTypesRepository extends JpaRepository<VisitorTypes,Integer>{
    // JpaRepository is a JPA specific extension of Repository. It contains the full API of CrudRepository and PagingAndSortingRepository. So it contains API for basic CRUD operations and also API for pagination and sorting.
    // Here, we are working with VisitorTypes as the domain type and the id type is Integer.
} 
