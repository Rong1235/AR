package sw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sw.dao.MenuDao;
import sw.entity.Menu;
import sw.model.MMenu;
import sw.service.ILeftMenuService;

/**
 * 
 * 左侧菜单栏
 * @author LR
 *
 */	
@Service
public class LeftMenuServiceImpl implements ILeftMenuService {
	
	@Autowired
	private MenuDao menuDao;


	
	@Override
	public MMenu findMenuByRoot(Integer root) {
		List <Menu> menus = (List<Menu>) menuDao.findAll();
		Menu mu = menuDao.findOne(root);
		MMenu model = new MMenu(mu);
		model =treeMenuList(menus, root,model);
		return model;
	}
	
	
	/**
	 * 构建菜单树结构
	 * @param menuList
	 * @param pid
	 * @param parent
	 * @return
	 */
	public MMenu treeMenuList(List<Menu> menuList, int pid,MMenu parent) {
		List<MMenu> children = parent.getChildren();
		if(null == children) children =new ArrayList<MMenu>();
		for (Menu mu : menuList) {
			MMenu model = new MMenu(mu);
			// 遍历出父id等于参数的id，add进子节点集合
			if (Integer.valueOf(mu.getPid()) == pid) {
				// 递归遍历下一级
				children.add(model);
				treeMenuList(menuList, mu.getId(),model);
				
			}
		}
		parent.setChildren(children);
		return parent;
	}


	@Override
	public int addMenu() {
	
		List<Menu> menuList = new ArrayList<Menu>();
		
		menuList.add(new Menu(1,"风险评估系统","#",0));
		menuList.add(new Menu(2,"项目管理", "", 1));
		menuList.add(new Menu(3,"人员管理", "", 2));
		menuList.add(new Menu(4,"依据文件管理","",2));
		return 0;
	}
	
//	@Override
//	public List<Map<String, Object>> showMenuTree() {
//		List <Menu> menus = (List<Menu>) menuDao.findAll();
//		List<Map<String, Object>> menuTree = buildTree(menus, -1);
//		return menuTree;
//	}


}
