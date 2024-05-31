package com.elvin.salesBackEndApp.repository;

import org.springframework.stereotype.Repository;
import com.elvin.salesBackEndApp.entity.Shop;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;




@Repository
public interface ShopRepository extends JpaRepository<Shop, UUID> {
    boolean existsByPhoneNumber(String phoneNumber);
    Optional<Shop> findOneByPhoneNumber(String phoneNumber);
}

// available methods
//     @Override
//     public List<Shop> findAll() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public List<Shop> findAllById(Iterable<UUID> ids) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAllById'");
//     }

//     @Override
//     public <S extends Shop> List<S> saveAll(Iterable<S> entities) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
//     }

//     @Override
//     public long count() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'count'");
//     }

//     @Override
//     public void delete(Shop entity) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'delete'");
//     }

//     @Override
//     public void deleteAll() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
//     }

//     @Override
//     public void deleteAll(Iterable<? extends Shop> entities) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
//     }

//     @Override
//     public void deleteAllById(Iterable<? extends UUID> ids) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAllById'");
//     }

//     @Override
//     public void deleteById(UUID id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
//     }

//     @Override
//     public boolean existsById(UUID id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'existsById'");
//     }

//     @Override
//     public Optional<Shop> findById(UUID id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findById'");
//     }

//     @Override
//     public <S extends Shop> S save(S entity) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'save'");
//     }

//     @Override
//     public List<Shop> findAll(Sort sort) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public Page<Shop> findAll(Pageable pageable) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public <S extends Shop> long count(Example<S> example) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'count'");
//     }

//     @Override
//     public <S extends Shop> boolean exists(Example<S> example) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'exists'");
//     }

//     @Override
//     public <S extends Shop> Page<S> findAll(Example<S> example, Pageable pageable) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public <S extends Shop, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findBy'");
//     }

//     @Override
//     public <S extends Shop> Optional<S> findOne(Example<S> example) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findOne'");
//     }

//     @Override
//     public void flush() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'flush'");
//     }

//     @Override
//     public <S extends Shop> S saveAndFlush(S entity) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'saveAndFlush'");
//     }

//     @Override
//     public <S extends Shop> List<S> saveAllAndFlush(Iterable<S> entities) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'saveAllAndFlush'");
//     }

//     @Override
//     public void deleteAllInBatch(Iterable<Shop> entities) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
//     }

//     @Override
//     public void deleteAllByIdInBatch(Iterable<UUID> ids) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAllByIdInBatch'");
//     }

//     @Override
//     public void deleteAllInBatch() {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'deleteAllInBatch'");
//     }

//     @Override
//     public Shop getOne(UUID id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getOne'");
//     }

//     @Override
//     public Shop getById(UUID id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getById'");
//     }

//     @Override
//     public Shop getReferenceById(UUID id) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'getReferenceById'");
//     }

//     @Override
//     public <S extends Shop> List<S> findAll(Example<S> example) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }

//     @Override
//     public <S extends Shop> List<S> findAll(Example<S> example, Sort sort) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'findAll'");
//     }    

