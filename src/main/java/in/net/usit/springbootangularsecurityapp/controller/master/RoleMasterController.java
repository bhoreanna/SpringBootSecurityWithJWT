package in.net.usit.springbootangularsecurityapp.controller.master;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.qos.logback.core.net.SyslogOutputStream;
import in.net.usit.springbootangularsecurityapp.bointeface.master.ModuleMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.bointeface.master.RoleMasterBOInterface;
import in.net.usit.springbootangularsecurityapp.component.master.ModuleMaster;
import in.net.usit.springbootangularsecurityapp.component.master.RoleMaster;
import in.net.usit.springbootangularsecurityapp.component.master.ScreenMaster;
import in.net.usit.springbootangularsecurityapp.component.master.UserMaster;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping(value = "/roleMaster")
public class RoleMasterController {
	
	@Autowired
	private RoleMasterBOInterface roleMasterService;
	

	@Autowired
	private ModuleMasterBOInterface  moduleMasterService;
	
	public RoleMasterController() {
		
	}
	
	//http://localhost:4200/roleMaster/roleMasterList
	
	@RequestMapping(value = "/roleMasterList")
	public List<RoleMaster> roleMasterList() {
		System.out.println("i am in roleMasterList in main Controllar");
		List<RoleMaster> roleMasterList = roleMasterService.getRoleMasterList();
		System.out.println("roleMasterList List Size in Controller: " + roleMasterList.size());
		

		return roleMasterList;
	}
	
	//  roleMaster/roleMasterByRoleId/{roleId}
	
	@RequestMapping(value = "/roleMasterByRoleId/{roleId}")
	public RoleMaster roleMasterByRoleId(@PathVariable String roleId) {

		System.out.println("roleId: " + roleId);
		RoleMaster roleMaster = roleMasterService.roleMasterByRoleId(roleId);
		System.out.println("roleMaster: " + roleMaster.getRoleId());
		


		return roleMaster
				;
	}

	
	
	
	@RequestMapping(value = "/saveRoleMaster", method = RequestMethod.POST)
	public boolean saveRoleMaster(@RequestBody RoleMaster roleMaster) {
		
		
		System.out.println("roleMaster Id: " + roleMaster.getRoleId());
		System.out.println("ModuleMasterList: " + roleMaster.getModuleMasterList().size());
		
		roleMaster.getModuleMasterList().forEach(e->{
			System.out.println("Moduleid: " +e.getModuleId());
			System.out.println("Module Name: "+ e.getModuleName());
			System.out.println("Screen List Size: " + e.getScreenMasterList().size());
		});
		roleMasterService.saveRoleMaster(roleMaster);



		return true;
	}
	
	


}
