/**
 * 
 */
package com.monitor.app.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.monitor.app.dataobject.User;

/**
 * @author Administrator
 *
 */
public interface UserDao {

	  @Select("SELECT * FROM cr_customer")
	  @Results(value = { @Result(id = true, property = "customerId", column = "customer_id"), 
			  @Result(property = "customerType", column = "customer_type"),
			  @Result(property = "customerName", column = "customer_name"),
			  @Result(property = "customerAddress", column = "customer_address"),
			  @Result(property = "contactName", column = "contact_name"),
			  @Result(property = "contactPhone", column = "contact_phone"),
			  @Result(property = "contactEmail", column = "contact_email")})
	  List<User> getUsers();
	 
	  @Select("SELECT * FROM cr_customer WHERE customer_id = #{customerId}")
	  User getUser(@Param("customerId") long customerId);
	  
	  
	  @Select("insert into cr_customer (customer_type,customer_name,customer_address,contact_name,contact_phone,contact_email) "
	  		+ "values (#{customerType}, #{customerName}, #{customerAddress}, #{contactName}, #{contactPhone}, #{contactEmail})")
	  void addUser(@Param("customerType") int customerType, @Param("customerName") String customerName,
			  @Param("customerAddress")String customerAddress, @Param("contactName")String contactName,
			  @Param("contactPhone")String contactPhone, @Param("contactEmail")String contactEmail);
	  
	  
	  
}
