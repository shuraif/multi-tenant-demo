package com.ms.multitenant.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ms.multitenant.entity.model.UserDetail;

@Repository
public interface UserDetailsRepo extends CrudRepository<UserDetail, Integer>{

	UserDetail findByPhoneHash(String phoneNo);

	List<UserDetail> findByPhoneHashIn(List<String> phoneNums);

}
