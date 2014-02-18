/**
 * 
 */
package com.monitor.app.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.monitor.app.dao.user.UserDao;
import com.monitor.app.dataobject.User;
import com.monitor.app.result.ServiceResult;
import com.monitor.app.result.msg.MsgEnum;
import com.monitor.app.utils.MsgUtils;

/**
 * @author Administrator
 *
 */
@Service
public class UserService {

	private static final Logger log = LoggerFactory.getLogger(UserService.class);

	@Resource
	private UserDao userDao;
	
	
	public ServiceResult addUser(int customerType, String customerName, String customerAddress,
			String contactName, String  contactPhone, String contactEmail){
		userDao.addUser(customerType, customerName, customerAddress, contactName, contactPhone, contactEmail);
		
		ServiceResult result = new ServiceResult(true);
		return result;
	}
	
	public ServiceResult queryAllUser(){
		ServiceResult result = null;
		try{
			//1.query
			List<User> users = userDao.getUsers();
			if(users!=null && !users.isEmpty()){
				
				return MsgUtils.fillModule(users);
			}
			
			//2.fill msg
			result = MsgUtils.fillMsg(MsgEnum.USER_QUERY_EMPTY);
			
		}catch(Exception e){
			//3.error msg
			log.error("query_all_user_exception", e);
			result = MsgUtils.fillMsg(MsgEnum.FAIL_USER_QUERY);
		}
		
		return result;
	}
}
