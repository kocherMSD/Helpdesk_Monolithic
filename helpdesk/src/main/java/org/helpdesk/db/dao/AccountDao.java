package org.helpdesk.common.dao;

import java.util.ArrayList;
import java.util.List;

import org.helpdesk.db.model.BaseBusinessObject;
import org.helpdesk.db.model.Contracts;
import org.helpdesk.db.model.Devices;
import org.helpdesk.db.model.Users;
import org.helpdesk.webservice.model.AccountRequest;
import org.helpdesk.webservice.model.AccountViewResponse;
import org.helpdesk.webservice.model.Contract;
import org.helpdesk.webservice.model.Device;
import org.helpdesk.webservice.model.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

public class AccountDao  extends FastTrackDataService{
	
	
	public void saveUpdate(AccountRequest request)
	{
		List<Device> devices=request.getDevices();
		User user =request.getUser();
		Contract contract=request.getContract();
		
		Users userdb=new Users();
		
		if(findUser(user.getCcoid()).getCcoid()!=null)
		{
			userdb.setId(findUser(user.getCcoid()).getId());
			devices=new ArrayList<Device>();
		}
		
		userdb.setAccesslevel(user.getAccesslevel());
		userdb.setAppointmentCapability(user.getAppointmentCapability());
		userdb.setCcoid(user.getCcoid());
		userdb.setCompanyname(user.getCompanyname());
		userdb.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		userdb.setCrparty_id(user.getCrparty_id());
		userdb.setEmailaddress(user.getEmailaddress());
		userdb.setErpparty_id(user.getErpparty_id());
		userdb.setFirstname(user.getFirstname());
		userdb.setGu_id(user.getGu_id());
		userdb.setLastname(user.getLastname());
		
		saveOrUpdate(userdb);
		evict(userdb);
		
		
		Contracts contractdb=new Contracts();
		if(findContract(user.getCcoid()).getContractnumber()!=null)
		{
			contractdb.setId(findContract(user.getCcoid()).getId());
		}
		
		contractdb.setBilltoparty_id(contract.getBilltoparty_id());
		contractdb.setBilltositeuse_id(contract.getBilltositeuse_id());
		contractdb.setCcoid(contract.getCcoid());
		contractdb.setContractexpdate(contract.getContractexpdate());
		contractdb.setContractnumber(contract.getContractnumber());
		contractdb.setContractstatus(contract.getContractstatus());
		contractdb.setContracttype(contract.getContracttype());
		contractdb.setEntitlementKey(contract.getEntitlementKey());
		contractdb.setServicelinedesc(contract.getServicelinedesc());
		contractdb.setServicelineenddate(contract.getServicelineenddate());
		contractdb.setServicelinestatus(contract.getServicelinestatus());
		contractdb.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
		contractdb.setVersion("0");
		
		saveOrUpdate(contractdb);
		evict(contractdb);
		
		for(Device device:devices)
		{
			Devices devdb=new Devices();
			
			devdb.setContractnumber(device.getContractnumber());
			devdb.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
			devdb.setPID(device.getPID());
			devdb.setProduct_id(device.getProduct_id());
			devdb.setSerialnumber(device.getSerialnumber());
			devdb.setServicelineID(device.getServicelineID());
			devdb.setSupported(device.getSupported());
			devdb.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
			devdb.setVersion("0");
		

			saveOrUpdate(devdb);
			evict(devdb);
			
			
		}
	}
		
		
		public void delete(AccountRequest request)
		{
			List<Device> devices=request.getDevices();
			User user =request.getUser();
			Contract contract=request.getContract();
			
			
			
			Users userdb=new Users();
			if(findUser(user.getCcoid()).getCcoid()!=null)
			{
				userdb.setId(findUser(user.getCcoid()).getId());
			}
			userdb.setAccesslevel(user.getAccesslevel());
			userdb.setAppointmentCapability(user.getAppointmentCapability());
			userdb.setCcoid(user.getCcoid());
			userdb.setCompanyname(user.getCompanyname());
			userdb.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
			userdb.setCrparty_id(user.getCrparty_id());
			userdb.setEmailaddress(user.getEmailaddress());
			userdb.setErpparty_id(user.getErpparty_id());
			userdb.setFirstname(user.getFirstname());
			userdb.setGu_id(user.getGu_id());
			userdb.setLastname(user.getLastname());
			
			delete(userdb);
			evict(userdb);
			
			
			Contracts contractdb=new Contracts();
			if(findContract(user.getCcoid()).getContractnumber()!=null)
			{
				contractdb.setId(findContract(user.getCcoid()).getId());
			}
			contractdb.setBilltoparty_id(contract.getBilltoparty_id());
			contractdb.setBilltositeuse_id(contract.getBilltositeuse_id());
			contractdb.setCcoid(contract.getCcoid());
			contractdb.setContractexpdate(contract.getContractexpdate());
			contractdb.setContractnumber(contract.getContractnumber());
			contractdb.setContractstatus(contract.getContractstatus());
			contractdb.setContracttype(contract.getContracttype());
			contractdb.setEntitlementKey(contract.getEntitlementKey());
			contractdb.setServicelinedesc(contract.getServicelinedesc());
			contractdb.setServicelineenddate(contract.getServicelineenddate());
			contractdb.setServicelinestatus(contract.getServicelinestatus());
			contractdb.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
			contractdb.setVersion("0");
			
			
			delete(contractdb);
			evict(contractdb);
			
			for(Device device:devices)
			{
				Devices devdb=new Devices();
				
				devdb.setContractnumber(device.getContractnumber());
				devdb.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
				devdb.setPID(device.getPID());
				devdb.setProduct_id(device.getProduct_id());
				devdb.setSerialnumber(device.getSerialnumber());
				devdb.setServicelineID(device.getServicelineID());
				devdb.setSupported(device.getSupported());
				devdb.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
				devdb.setVersion("0");
			

				delete(devdb);
				evict(devdb);
				
				
			}
		
		
	}
		public AccountViewResponse findAcountRequest(String userId) {
			
			AccountViewResponse res=new AccountViewResponse();
			Users user=findUser(userId);
			Contracts contract=findContract(userId);
			List<Devices> devices =findDevices(contract.getContractnumber());
			
			
			User userWS=new User();
			userWS.setAccesslevel(user.getAccesslevel());
			userWS.setAppointmentCapability(user.getAppointmentCapability());
			userWS.setCcoid(user.getCcoid());
			userWS.setCompanyname(user.getCompanyname());
			userWS.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
			userWS.setCrparty_id(user.getCrparty_id());
			userWS.setEmailaddress(user.getEmailaddress());
			userWS.setErpparty_id(user.getErpparty_id());
			userWS.setFirstname(user.getFirstname());
			userWS.setGu_id(user.getGu_id());
			userWS.setLastname(user.getLastname());
			res.setUser(userWS);
			
			
			Contract contractws=new Contract();
			contractws.setBilltoparty_id(contract.getBilltoparty_id());
			contractws.setBilltositeuse_id(contract.getBilltositeuse_id());
			contractws.setCcoid(contract.getCcoid());
			contractws.setContractexpdate(contract.getContractexpdate());
			contractws.setContractnumber(contract.getContractnumber());
			contractws.setContractstatus(contract.getContractstatus());
			contractws.setContracttype(contract.getContracttype());
			contractws.setEntitlementKey(contract.getEntitlementKey());
			contractws.setServicelinedesc(contract.getServicelinedesc());
			contractws.setServicelineenddate(contract.getServicelineenddate());
			contractws.setServicelinestatus(contract.getServicelinestatus());
			contractws.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
			contractws.setVersion("0");
			res.setContract(contractws);
			
			List<Device> devicesws=new ArrayList<Device>(); 

			for(Devices device:devices)
			{
				Device devws=new Device();
				
				devws.setContractnumber(device.getContractnumber());
				devws.setCreated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
				devws.setPID(device.getPID());
				devws.setProduct_id(device.getProduct_id());
				devws.setSerialnumber(device.getSerialnumber());
				devws.setServicelineID(device.getServicelineID());
				devws.setSupported(device.getSupported());
				devws.setUpdated_date(""+new java.sql.Date(new java.util.Date().getSeconds()));
				devws.setVersion("0");
				devicesws.add(devws);

				
				
			}
			res.setDevices(devicesws);
				
			
			return res;
			
	}
		
		

		public Users findUser(String userId) {
			
				List<Users> users = new ArrayList<Users>();

				DetachedCriteria criteria = DetachedCriteria.forClass(Users.class);
				criteria.add(Restrictions.eq("ccoid", userId));
				List<BaseBusinessObject> retObj = findByCriteria(criteria);
				for (BaseBusinessObject bo : retObj) {
					users.add((Users) bo);
				}
				return users.size()==0?new Users():users.get(0);
			}
			
		
		public Contracts findContract(String userId) {
			
			List<Contracts> contracts = new ArrayList<Contracts>();
		
			DetachedCriteria criteria = DetachedCriteria.forClass(Contracts.class);
			criteria.add(Restrictions.eq("ccoid", userId));
			List<BaseBusinessObject> retObj = findByCriteria(criteria);
			for (BaseBusinessObject bo : retObj) {
				contracts.add((Contracts) bo);
			}
			return contracts.size()==0?new Contracts():contracts.get(0); 
		}
	
       
		public List<Devices> findDevices(String contractNumber) {
			
			List<Devices> devices = new ArrayList<Devices>();
		
			DetachedCriteria criteria = DetachedCriteria.forClass(Devices.class);
			criteria.add(Restrictions.eq("contractnumber", contractNumber));
			List<BaseBusinessObject> retObj = findByCriteria(criteria);
			for (BaseBusinessObject bo : retObj) {
				devices.add((Devices) bo);
			}
			return devices;
		}



}
