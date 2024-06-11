package org.yenicilh.testprocedure.repository;


import org.postgresql.util.PGobject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yenicilh.testprocedure.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "select * from public.save_product(?:: public.productudt, ?)", nativeQuery = true)
    void saveProductWithSchema(@Param("product") PGobject product, @Param("schema_name")String schemaName);

    @Query(value = "select * from public.save_product(?::productudt, ?)", nativeQuery = true)
    Product saveProduct(@Param("product") PGobject product, @Param("schema_name")String schemaName);

    @Query(value = "SELECT * FROM new_schema.save_product(:schema_name, CAST(:product_data AS new_schema.product_type))", nativeQuery = true)
    Product saveProduct(@Param("schema_name") String schemaName, @Param("product_data") PGobject productData);
}
