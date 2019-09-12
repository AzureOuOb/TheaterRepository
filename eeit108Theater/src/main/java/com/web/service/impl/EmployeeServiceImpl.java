package com.web.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.dao.EmployeeDao;
import com.web.entity.EmployeeBean;
import com.web.service.EmployeeService;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{
@Autowired
	EmployeeDao employeeDao;
	
	@Override
	public void insertEmp(EmployeeBean empBean) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void updateEmp(EmployeeBean empBean) {
		
		employeeDao.updateEmployee(empBean);
		
	}

	@Override
	public void deleteEmp(Integer no) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public EmployeeBean findByPrimaryKey(Integer no) {
		
		return employeeDao.getEmployeeByNo(no);
	}
	
	@Override
	public List<EmployeeBean> getAllEmployees() {
		                     
		return employeeDao.getAllEmployees();
	}

	@Override
	public EmployeeBean addEmp(String name, String email, String password, String phoneNum) {
		
		return null;
	}

	@Override
	public Boolean checkEmpEmail(String email) {
		Boolean result = true;

		if (employeeDao.checkEmpEmail(email) == null) {
			result = false;
		}
		return result;
	}

	@Override
	public Integer save(EmployeeBean empBean) {
		if( empBean !=null) {
			System.out.println("emp insert not null");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			SimpleDateFormat ssdf = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				empBean.setBirthday(ssdf.parse(empBean.getBirthdayString()));  //set員工生日 將輸入的string 轉成date type
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			empBean.setRegisterTime(new Date()); //set 員工註冊時間 (熊設計的表格是設定not null 一定要填)
			empBean.setAvailable(true); //set 員工Available 預設true
			empBean.setPermission(1); //set 員工Permission 預設1
			//save 員工時 如果想要依照需求額外儲存內容 可加在下面
			
			employeeDao.saveEmployee(empBean);
			
		}else {
			System.out.println("emp insert null");
		}
		
		return null;
	}

	

}
