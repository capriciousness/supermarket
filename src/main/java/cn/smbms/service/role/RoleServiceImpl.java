package cn.smbms.service.role;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import cn.smbms.dao.role.RoleMapper;
import cn.smbms.dao.user.UserMapper;
import cn.smbms.pojo.Role;

@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private UserMapper userMapper;
	@Override
	public List<Role> getRoleList() throws Exception{
		return roleMapper.getRoleList();
	}

	@Override
	public boolean add(Role role) throws Exception {
		boolean flag = false;
		if(roleMapper.add(role) > 0)
			flag = true;
		return flag;
	}

	@Override
	public boolean deleteRoleById(Integer delId) throws Exception {
		boolean flag = false;
		if(userMapper.getUserCount(null, delId) == 0){
			if(roleMapper.deleteRoleById(delId) > 0)
				flag = true;
		}
		return flag;
	}

	@Override
	public boolean modify(Role role) throws Exception {
		boolean flag = false;
		if(roleMapper.modify(role) > 0)
			flag = true;
		return flag;
	}

	@Override
	public Role getRoleById(Integer id) throws Exception {
		return roleMapper.getRoleById(id);
	}

	@Override
	public int roleCodeIsExist(String roleCode) throws Exception {
		return roleMapper.roleCodeIsExist(roleCode);
	}
	
}
